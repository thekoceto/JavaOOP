package aquarium.models.fish;

public class SaltwaterFish extends BaseFish{
    private static final int INITIAL_SIZE = 5;
    private static final int INCREASES_EAT = 2;
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
