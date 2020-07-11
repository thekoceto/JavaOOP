package P03_ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;
    //-	name: String
    //-	money:  double
    //-	products:  List<Product>

    //+ Person (String ,  double)
    public Person(String name, double money) {
        this.setName(name);
        this.setMoney(money);
        this.products = new ArrayList<>();
    }

    //+	getName(): String
    public String getName() {
        return this.name;
    }

    //-	setName (String) : void
    private void setName(String name) {
        if (name == null || name.trim().isEmpty() || name.contains("\\W+"))
            throw new IllegalArgumentException("Name cannot be empty");
        this.name = name;
    }

    //-	setMoney (double) : void
    private void setMoney(double money) {
        if (money<0)
            throw new IllegalArgumentException("Money cannot be negative");
        this.money = money;
    }

    //+	buyProduct (Product) : void
    public void buyProduct(Product product) {
        if (this.money < product.getCost())
            throw new IllegalArgumentException(this.name + " can't afford " + product.getName());
        else {
            this.setMoney(this.money - product.getCost());
            products.add(product);
            System.out.println(this.name + " bought " + product.getName());
        }
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        out.append(this.name).append(" - ");
        if (products.isEmpty())
            out.append("Nothing bought");
        else{
            String str = "";
            for (Product product : products) {
                out.append(str).append(product.getName());
                str = ", ";
            }
        }
        return out.toString().trim();
    }
}
