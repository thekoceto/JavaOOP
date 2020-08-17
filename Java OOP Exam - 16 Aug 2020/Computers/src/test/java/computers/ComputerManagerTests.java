package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ComputerManagerTests {
    private ComputerManager computerManager;
    private Computer computer;

    @Before
    public void createInstances() {
        this.computerManager = new ComputerManager();
        this.computer = new Computer("manufacturer", "model", 1.0d);
    }

    @Test
    public void getComputersAndCheckSize(){
        this.computerManager.addComputer(this.computer);
        Assert.assertEquals(1, computerManager.getComputers().size());
    }
    @Test
    public void getCountAndCheckSize(){
        this.computerManager.addComputer(this.computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getComputersAndTryModifyThrowUnsupportedOperationException(){
        computerManager.getComputers().add(this.computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerAddNullThrowIllegalArgumentException(){
        computerManager.addComputer(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addComputerAddExistThrowIllegalArgumentException(){
        computerManager.addComputer(this.computer);
        computerManager.addComputer(this.computer);
    }

    @Test
    public void removeComputersAndCheckSize(){
        this.computerManager.addComputer(this.computer);
        Assert.assertEquals(1, computerManager.getComputers().size());
        this.computerManager.removeComputer(this.computer.getManufacturer(),this.computer.getModel());
        Assert.assertEquals(0, computerManager.getComputers().size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerTryNullManufacturerThrowIllegalArgumentException(){
        computerManager.getComputer(null, this.computer.getModel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getComputerTryNullModelThrowNullIllegalArgumentException(){
        computerManager.getComputer(this.computer.getManufacturer(), null);
    }

    @Test
    public void getComputersByManufacturerAndCheckSize(){
        this.computerManager.addComputer(this.computer);
        int size = this.computerManager.getComputersByManufacturer(this.computer.getManufacturer()).size();
        Assert.assertEquals(1, size);
    }
}