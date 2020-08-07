package halfLife;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player

    @Test
    public void getUsernameReturnCorrectValue(){
        Player player = new Player("name", 100);
        Assert.assertEquals("name", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void setUsername1ThrowNullPointerException(){
        Player player = new Player("", 100);
    }

    @Test(expected = NullPointerException.class)
    public void setUsername2ThrowNullPointerException(){
        Player player = new Player("  ", 100);
    }

    @Test
    public void getHealthReturnCorrectValue(){
        Player player = new Player("name", 100);
        Assert.assertEquals(100, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void setHealthThrowIllegalArgumentException(){
        Player player = new Player("name", -1);
    }

    @Test
    public void getGunsReturnCorrectValue(){
        Player player = new Player("name", 100);
        player.addGun(new Gun("first", 100));
        player.addGun(new Gun("second", 100));
        Assert.assertEquals(2, player.getGuns().size());
    }

    @Test(expected = IllegalStateException.class)
    public void takeDamageThrowIllegalStateException(){
        Player player = new Player("name", 10);
        player.takeDamage(10);
        player.takeDamage(1);
    }

    @Test(expected = NullPointerException.class)
    public void addGunThrowNullPointerException(){
        Player player = new Player("name", 10);
        player.addGun(null);
    }

    @Test
    public void addGunReturnCorrectValue(){
        Player player = new Player("name", 100);
        player.addGun(new Gun("first", 100));
        Assert.assertEquals(1, player.getGuns().size());
    }

    @Test
    public void removeGunReturnCorrectValue(){
        Player player = new Player("name", 100);
        Gun gun = new Gun("first", 100);
        player.addGun(gun);
        Assert.assertTrue(player.removeGun(gun));
    }

    @Test
    public void getGunReturnCorrectValue(){
        Player player = new Player("name", 100);
        Gun gun = new Gun("name", 100);
        player.addGun(gun);
        Assert.assertEquals(gun, player.getGun("name"));
    }
}
