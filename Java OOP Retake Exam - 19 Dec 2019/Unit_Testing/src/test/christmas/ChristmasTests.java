package christmas;

import christmas.Present;
import christmas.PresentBag;
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
}
