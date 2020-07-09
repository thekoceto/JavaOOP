package P01_ClassBoxDataValidation;

public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (length <= 0)
            throw new IllegalArgumentException("Length cannot be zero or a negative number.");
        this.length = length;
    }

    private void setWidth(double width) {
        if (width <= 0)
            throw new IllegalArgumentException("Width cannot be zero or a negative number.");
        this.width = width;
    }

    private void setHeight(double height) {
        if (height <= 0)
            throw new IllegalArgumentException("Height cannot be zero or a negative number.");
        this.height = height;
    }

    public double calculateSurfaceArea(){
        return  2*this.length*this.width +
                2*this.width*this.height +
                2*this.height*this.length;
    }

    public double calculateLateralSurfaceArea(){
        return  2*this.width*this.height +
                2*this.height*this.length;
    }

    public double calculateVolume(){
        return  this.length*this.width*this.height;
    }
}
//-	length: double
//-	width:  double
//-	height:  double
//+ 	Box (double length, double width, double height)
//-	setLength(double): void
//-	setWidth(double): void
//-	setHeight(double): void

//+	calculateSurfaceArea (): double
//+	calculateLateralSurfaceArea (): double
//+	calculateVolume (): double