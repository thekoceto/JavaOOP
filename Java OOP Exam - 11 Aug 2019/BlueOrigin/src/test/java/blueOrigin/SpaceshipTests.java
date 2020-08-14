package blueOrigin;

import org.junit.Assert;
import org.junit.Test;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    @Test
    public void getCountReturnCorrectResult(){
        Spaceship spaceship = new Spaceship("name", 10);
        Assert.assertEquals(0, spaceship.getCount());
    }

    @Test
    public void getNameReturnCorrectResult(){
        Spaceship spaceship = new Spaceship("name", 10);
        Assert.assertEquals("name", spaceship.getName());
    }

    @Test
    public void getCapacityReturnCorrectResult(){
        Spaceship spaceship = new Spaceship("name", 10);
        Assert.assertEquals(10, spaceship.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addAstronautOverCapacityThrowIllegalArgumentException(){
        Spaceship spaceship = new Spaceship("name", 0);
        spaceship.add(new Astronaut("name", 0.0));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExistedAstronautThrowIllegalArgumentException(){
        Spaceship spaceship = new Spaceship("name", 2);
        spaceship.add(new Astronaut("name", 0.0));
        spaceship.add(new Astronaut("name", 0.0));
    }

    @Test
    public void addAstronautReturnCorrectResult(){
        Spaceship spaceship = new Spaceship("name", 2);
        Astronaut astronaut = new Astronaut("name", 0.0);
        spaceship.add(astronaut);
        Assert.assertEquals(1, spaceship.getCount());
    }

    @Test
    public void removeAstronautReturnTrue(){
        Spaceship spaceship = new Spaceship("name", 2);
        spaceship.add(new Astronaut("name", 0.0));
        Assert.assertTrue(spaceship.remove("name"));
    }

    @Test
    public void removeAstronautReturnFalse(){
        Spaceship spaceship = new Spaceship("name", 2);
        spaceship.add(new Astronaut("name", 0.0));
        Assert.assertFalse(spaceship.remove("falseName"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInvalidCapacityThrowIllegalArgumentExceptiont(){
        Spaceship spaceship = new Spaceship("name", -1);
    }

    @Test(expected = NullPointerException.class)
    public void setInvalidNameThrowNullPointerException(){
        Spaceship spaceship = new Spaceship("", 10);
    }

    @Test(expected = NullPointerException.class)
    public void setInvalidName2ThrowNullPointerException(){
        Spaceship spaceship = new Spaceship("  ", 10);
    }
}
