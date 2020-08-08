package aquarium.models.fish;

public class SaltwaterFish extends BaseFish{
    public static int INITIAL_SIZE = 5;
    public static int INCREASES_EAT = 2;
    //only in SaltwaterAquarium!

    public SaltwaterFish(String name, String species, double price) {
        super(name, species, price);
        super.setSize(INITIAL_SIZE);
    }

    @Override
    public void eat() {
        super.setSize(super.getSize() + INCREASES_EAT);
    }
}
