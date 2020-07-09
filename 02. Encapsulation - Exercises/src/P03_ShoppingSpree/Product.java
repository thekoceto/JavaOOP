package P03_ShoppingSpree;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost) {
        this.setName(name);
        this.setCost(cost);
    }

    public String getName() {
        return name;
    }

    public double getCost() {
        return cost;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.contains(" "))
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }

}
//+ 	Product (String,  double)
//-	setCost (double): void
//-	setName (String): void
//+	getName(): String
//+	getCost (): double