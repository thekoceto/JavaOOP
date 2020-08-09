package aquarium.models.decorations;

public class Ornament extends  BaseDecoration{
    private static final int INITIAL_COMFORT = 1;
    private static final double INITIAL_PRICE = 5d;

    public Ornament() {
        super(INITIAL_COMFORT, INITIAL_PRICE);
    }
}
