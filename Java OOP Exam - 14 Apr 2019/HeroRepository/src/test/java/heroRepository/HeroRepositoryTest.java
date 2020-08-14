package heroRepository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroRepositoryTest {
    private HeroRepository heroRepository;

    @Before
    public void createInstances() {
        this.heroRepository = new HeroRepository();
    }

    @Test(expected = IllegalArgumentException.class)
    public void addExistHeroThrowIllegalArgumentException(){
        Hero hero = new Hero("first", 1, new Item(1, 1,1));
        this.heroRepository.add(hero);
        this.heroRepository.add(hero);
    }

    @Test
    public void addHeroAndCheckHeroRepositorySize(){
        Hero hero = new Hero("first", 1, new Item(1, 1,1));
        heroRepository.add(hero);
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test(expected = NullPointerException.class)
    public void removeNotExistHeroThrowNullPointerException(){
        this.heroRepository.remove("fakeName");
    }

    @Test
    public void removeHeroAndCheckHeroRepositorySize(){
        Hero hero1 = new Hero("first", 1, new Item(1, 1,1));
        Hero hero2 = new Hero("second", 2, new Item(2, 2,2));
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        this.heroRepository.remove("first");
        Assert.assertEquals(1, this.heroRepository.getCount());
    }

    @Test
    public void getHeroWithHighestStrengthCheckCorrectAnswer(){
        Hero hero1 = new Hero("first", 1, new Item(1, 1,1));
        Hero hero2 = new Hero("second", 1, new Item(2, 1,1));
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestStrength());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestStrengthThrowNullPointerException(){
        this.heroRepository.getHeroWithHighestStrength();
    }

    @Test
    public void getHeroWithHighestAgilityCheckCorrectAnswer(){
        Hero hero1 = new Hero("first", 1, new Item(1, 1,1));
        Hero hero2 = new Hero("second", 1, new Item(1, 2,1));
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestAgility());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestAgilityThrowNullPointerException(){
        this.heroRepository.getHeroWithHighestAgility();
    }

    @Test
    public void getHeroWithHighestIntelligenceCheckCorrectAnswer(){
        Hero hero1 = new Hero("first", 1, new Item(1, 1,1));
        Hero hero2 = new Hero("second", 1, new Item(1, 1,2));
        this.heroRepository.add(hero1);
        this.heroRepository.add(hero2);
        Assert.assertEquals(hero2, this.heroRepository.getHeroWithHighestIntelligence());
    }

    @Test(expected = NullPointerException.class)
    public void getHeroWithHighestIntelligenceThrowNullPointerException(){
        this.heroRepository.getHeroWithHighestIntelligence();
    }
}