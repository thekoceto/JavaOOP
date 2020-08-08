package computers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerTest {
   //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Computer
    @Test
    public void getNameReturnCorrectResult(){
        Computer computer = new Computer("Name");
        Assert.assertEquals("Name", computer.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameThrowIllegalArgumentExceptionTest1(){
        Computer computer = new Computer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setNameThrowIllegalArgumentExceptionTest2(){
        Computer computer = new Computer("");
    }

    @Test
    public void setNameReturnCorrectResult(){
        Computer computer = new Computer("Name");
        Assert.assertEquals("Name", computer.getName());
    }

    @Test
    public void getPartsCheckSizeList(){
        Computer computer = new Computer("Name");
        computer.addPart(new Part("first", 1.0));
        computer.addPart(new Part("second", 2.0));
        Assert.assertEquals(2, computer.getParts().size());
    }

    @Test
    public void getTotalPriceReturnCorrectResult(){
        Computer computer = new Computer("Name");
        computer.addPart(new Part("first", 1.0));
        computer.addPart(new Part("second", 2.0));
        Assert.assertEquals(3.0, computer.getTotalPrice(), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addPartThrowIllegalArgumentException(){
        Computer computer = new Computer("Name");
        computer.addPart(null);
    }

    @Test
    public void addPartReturnCorrectResult(){
        Computer computer = new Computer("Name");
        Part part = new Part("Name", 1.0);
        computer.addPart(part);
        Assert.assertEquals(part, computer.getPart("Name"));
    }

    @Test
    public void removePartReturnCorrectResult(){
        Computer computer = new Computer("Name");
        Part part = new Part("Name", 1.0);
        computer.addPart(part);
        Assert.assertTrue(computer.removePart(part));
    }

    @Test
    public void getPartReturnCorrectResult(){
        this.addPartReturnCorrectResult();
    }
}