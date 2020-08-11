package unitTesting;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;

public class RaceEntryTest {
    private static final String RIDER_ADDED = "Rider rider added in race.";

    @Test(expected = NullPointerException.class)
    public void addRiderThrowNullPointerException(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addRiderThrowIllegalArgumentException(){
        RaceEntry raceEntry = new RaceEntry();
        UnitRider rider = new UnitRider("rider", new UnitMotorcycle("name", 1, 1d));
        raceEntry.addRider(rider);
        raceEntry.addRider(rider);
    }

    @Test
    public void addRiderReturnString(){
        RaceEntry raceEntry = new RaceEntry();
        UnitRider rider = new UnitRider("rider", new UnitMotorcycle("name", 1, 1d));
        Assert.assertEquals(RIDER_ADDED, raceEntry.addRider(rider));
    }

    @Test
    public void calculateAverageHorsePowerReturnCorrectValue(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("rider1", new UnitMotorcycle("name", 1, 1d)));
        raceEntry.addRider(new UnitRider("rider2", new UnitMotorcycle("name", 3, 1d)));
        Assert.assertEquals(2, raceEntry.calculateAverageHorsePower(), 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void calculateAverageHorsePowerThrowIllegalArgumentException(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.calculateAverageHorsePower();
    }
    @Test
    public void getRidersReturnCorrectValueAndCheckSize(){
        RaceEntry raceEntry = new RaceEntry();
        raceEntry.addRider(new UnitRider("rider1", new UnitMotorcycle("name", 1, 1d)));
        raceEntry.addRider(new UnitRider("rider2", new UnitMotorcycle("name", 3, 1d)));
        Assert.assertEquals(2, raceEntry.getRiders().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void etRidersThrowUnsupportedOperationExceptionTest1(){
        RaceEntry raceEntry = new RaceEntry();
        UnitRider rider = new UnitRider("rider", new UnitMotorcycle("name", 1, 1d));
        raceEntry.addRider(rider);
        raceEntry.getRiders().remove(rider);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getRidersAndAddThrowUnsupportedOperationExceptionTest2() {
        RaceEntry raceEntry = new RaceEntry();
        UnitRider rider = new UnitRider("rider", new UnitMotorcycle("name", 1, 1d));
        raceEntry.getRiders().add(rider);
    }
}
