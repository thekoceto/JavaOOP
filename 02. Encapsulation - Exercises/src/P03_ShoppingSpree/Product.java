package P03_ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    //+ Product (String,  double)
    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //+	getCost (): double
    public double getCost() {
        return this.cost;
    }

    //-	setName (String): void
    private void setName(String name) {
        if (name == null || name.trim().isEmpty())
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    //-	setCost (double): void
    private void setCost(double cost) {
        if (cost<0)
            throw new IllegalArgumentException("Money cannot be negative");
        this.cost = cost;
    }

}
