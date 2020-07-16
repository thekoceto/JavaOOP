package P04_FoodShortage;

import P04_FoodShortage.interfaces.Buyer;
import P04_FoodShortage.interfaces.Person;

public class Rebel implements Person, Buyer {
    private String name;
    private int age;
    private String group;
    private int food;

    //+	Rebel(Stirng, int, String)
    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    //+	buyFood() : void
    @Override
    public void buyFood() {
        this.food += 5;
    }

    //+	getFood() : int
    @Override
    public int getFood() {
        return this.food;
    }

    //+	getGroup() : String
    public String getGroup() {
        return this.group;
    }

    //+	getName() : String
    @Override
    public String getName() {
        return this.name;
    }

    //+	getAge() : int
    @Override
    public int getAge() {
        return this.age;
    }

//-	name: String
    //-	age: int
    //-	group: String
    //-	food: int

}
