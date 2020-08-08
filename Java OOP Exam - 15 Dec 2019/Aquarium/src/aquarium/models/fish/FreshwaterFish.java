package aquarium.models.fish;

public class FreshwaterFish extends BaseFish{
    public static int INITIAL_SIZE = 3;
    public static int INCREASES_EAT = 3;
    //only in FreshwaterAquarium!

    public FreshwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + INCREASES_EAT);
    }
}
