package christmas;

import christmas.Present;
import christmas.PresentBag;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChristmasTests {
    private Present present;
    private PresentBag presentBag;

    @Before
    public void createInstances() {
        this.presentBag = new PresentBag();
        this.present = new Present("Name", 1.5);
    }

    @Test(expected = NullPointerException.class)
    public void shouldThrowExceptionIfNullPresent() {
        this.presentBag.create(null);
    }

    // test PresentBag
    @Test(expected = NullPointerException.class)
    public void createNullAndThrowNullPointerException() {
        presentBag.create(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void createExistPresentAndThrowIllegalArgumentException() {
        presentBag.create(present);
        presentBag.create(present);
    }

    @Test
    public void createReturnCorrectValue() {
        Assert.assertEquals("Successfully added present Name with magic 1.50", presentBag.create(present));
    }

    @Test(expected = NullPointerException.class)
    public void removeNullAndThrowNullPointerException() {
        presentBag.remove(null);
    }

    @Test
    public void removeReturnCorrectValue() {
        presentBag.create(present);
        Assert.assertTrue(present.getName(), presentBag.remove("Name"));
    }

    @Test
    public void getPresentReturnCorrectValue(){
        presentBag.create(present);
        Assert.assertEquals(1.5, presentBag.getPresent("Name").getMagic(), 0.0);
    }

    @Test
    public void getPresentWithLeastMagicReturnCorrectValue() {
        presentBag.create(present);
        presentBag.create(new Present("Name2", 1d));
        presentBag.create(new Present("Name3", 0.5d));
        Assert.assertEquals(presentBag.getPresentWithLeastMagic().getMagic(), 0.5, 0.0);
    }

    @Test
    public void getPresentsReturnCorrectValue(){
        presentBag.create(present);
        Assert.assertEquals(presentBag.getPresents().size(), 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void getPresentsThrowUnsupportedOperationException() {
        presentBag.getPresents().add(present);
    }
}
