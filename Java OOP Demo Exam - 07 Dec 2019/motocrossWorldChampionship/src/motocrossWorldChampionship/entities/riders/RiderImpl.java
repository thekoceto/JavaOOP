package motocrossWorldChampionship.entities.riders;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Motorcycle;
import motocrossWorldChampionship.entities.interfaces.Rider;

public class RiderImpl implements Rider {
    private static final int MIN_SYMBOLS = 5;

    private String name;
    private Motorcycle motorcycle;
    private int numberOfWins;
    private boolean canParticipate;

    public RiderImpl(String name) {
        this.name = name;
        this.motorcycle = null;
        this.numberOfWins = 0;
        this.canParticipate = false;
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_SYMBOLS )
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MIN_SYMBOLS));
        this.name = name;
    }
//
//    public void setCanParticipate() {
//        this.canParticipate = this.motorcycle != null;
//    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public Motorcycle getMotorcycle() {
        return this.motorcycle;
    }

    @Override
    public int getNumberOfWins() {
        return this.numberOfWins;
    }

    @Override
    public void addMotorcycle(Motorcycle motorcycle) {
        if (motorcycle == null)
            throw new NullPointerException (ExceptionMessages.MOTORCYCLE_INVALID);

        this.motorcycle = motorcycle;
        this.canParticipate = true;
    }

    @Override
    public void winRace() {
        this.numberOfWins++;
    }

    @Override
    public boolean getCanParticipate() {
        return this.canParticipate;
    }
}
