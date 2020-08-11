package motocrossWorldChampionship.entities.races;

import motocrossWorldChampionship.common.ExceptionMessages;
import motocrossWorldChampionship.entities.interfaces.Race;
import motocrossWorldChampionship.entities.interfaces.Rider;

import java.util.ArrayList;
import java.util.Collection;

public class RaceImpl implements Race {
    private static final int MIN_SYMBOLS = 5;
    private static final int MIN_LAPS = 1;

    private String name;
    private int laps;
    private Collection<Rider> riders;

    public RaceImpl(String name, int laps) {
        this.name = name;
        this.laps = laps;
        this.riders = new ArrayList<>();
    }

    public void setName(String name) {
        if (name == null || name.length() < MIN_SYMBOLS )
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NAME, name, MIN_SYMBOLS));
        this.name = name;
    }

    public void setLaps(int laps) {
        if (laps < MIN_LAPS)
            throw new IllegalArgumentException(String.format(ExceptionMessages.INVALID_NUMBER_OF_LAPS, MIN_LAPS));
        this.laps = laps;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getLaps() {
        return this.laps;
    }

    @Override
    public Collection<Rider> getRiders() {
        return this.riders;
    }

    @Override
    public void addRider(Rider rider) {
        if (rider == null)
            throw new NullPointerException(ExceptionMessages.RIDER_INVALID);
        if (rider.getMotorcycle() == null)
            throw new IllegalArgumentException (String.format(ExceptionMessages.RIDER_NOT_PARTICIPATE, rider.getName()));
        if (this.riderExisting(rider.getName()))
            throw new IllegalArgumentException (String.format(ExceptionMessages.RIDER_ALREADY_ADDED, this.name, rider.getName()));

        riders.add(rider);
    }

    private boolean riderExisting(String riderName){
        return riders.stream()
                .filter(rider -> rider.getName().equals(riderName))
                .findFirst()
                .orElse(null) != null;

    }
}
