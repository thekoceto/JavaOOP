package aquarium.models.fish;

public class FreshwaterFish extends BaseFish{
    private static final int INITIAL_SIZE = 3;
    private static final int INCREASES_EAT = 3;
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
