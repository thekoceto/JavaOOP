package santasWorkshop.models.dwarf;

public class Sleepy extends BaseDwarf{
    private static final int INITIAL_ENERGY = 50;

    public Sleepy(String name) {
        super(name, INITIAL_ENERGY);
    }

    @Override
    public void work() {
        super.setEnergy(super.getEnergy() - 5);
        if (super.getEnergy() < 0)
            super.setEnergy(0);
    }
}
