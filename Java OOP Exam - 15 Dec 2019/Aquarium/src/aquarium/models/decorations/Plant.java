package aquarium.models.decorations;

public class Plant extends  BaseDecoration{
    private static final int INITIAL_COMFORT = 5;
    private static final double INITIAL_PRICE = 10d;

    public Plant() {
        super(INITIAL_COMFORT, INITIAL_PRICE);
    }
}
