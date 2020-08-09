package aquarium;

import org.junit.Assert;
import org.junit.Test;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    @Test
    public void getNameReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        Assert.assertEquals("aqua", aquarium.getName());
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowNullPointerExceptionTest1(){
        Aquarium aquarium = new Aquarium(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void setNameThrowNullPointerExceptionTest2(){
        Aquarium aquarium = new Aquarium("", 10);
    }

    @Test
    public void setCapacityReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        Assert.assertEquals(10, aquarium.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setCapacityThrowIllegalArgumentException(){
        Aquarium aquarium = new Aquarium("aqua", -1);
    }

    @Test
    public void getCountReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        aquarium.add(new Fish("fish"));
        Assert.assertEquals(1, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void addThrowIllegalArgumentException(){
        Aquarium aquarium = new Aquarium("aqua", 0);
        aquarium.add(new Fish("fish"));
    }
//
//    @Test
//    public void addReturnCorrectValue(){
//        Aquarium aquarium = new Aquarium("name", 10);
//        aquarium.add(new Fish("fish"));
//        Assert.assertEquals(1, aquarium.getCount());
//    }


    @Test(expected = IllegalArgumentException.class)
    public void removeThrowIllegalArgumentException(){
        Aquarium aquarium = new Aquarium("aqua", 1);
        aquarium.add(new Fish("fish"));
        aquarium.remove("fake");
    }

    @Test
    public void removeReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        aquarium.add(new Fish("fish"));
        aquarium.remove("fish");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void sellThrowIllegalArgumentException(){
        Aquarium aquarium = new Aquarium("aqua", 1);
        aquarium.add(new Fish("fish"));
        aquarium.sellFish("fake");
    }

    @Test
    public void sellReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        aquarium.add(new Fish("fish"));
        Fish fish = aquarium.sellFish("fish");
        Assert.assertFalse(fish.isAvailable());
    }

    @Test
    public void reportReturnCorrectValue(){
        Aquarium aquarium = new Aquarium("aqua", 10);
        aquarium.add(new Fish("fish"));
        Assert.assertEquals("Fish available at aqua: fish", aquarium.report());
    }

}