package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        Hero.clearAllHeroes();
    }

    @Test
    public Hero setUpNewHero(){
        return new Hero("Superman", 33, "Super Strength", "Not human");
    }

    @Test
    public void allHeroObjectsGetCorrectlyInstantiated_true(){
        Hero hero = setUpNewHero();
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void allHeroesAreCorrectlyReturned_true(){
        Hero hero = setUpNewHero();
        Hero anotherHero = new Hero("Spider-man", 20, "Make webs", "Small" );
        assertEquals(2, Hero.getInstances().size());
    }
    @Test
    public void getInstancesReturnsAllHeroes_true(){
        Hero hero = setUpNewHero();
        Hero anotherHero = new Hero("Spider-man", 20, "Make webs", "Small" );
        assertTrue(Hero.getInstances().contains(hero));
        assertTrue(Hero.getInstances().contains(anotherHero));
    }

    @Test
    void getAge() {
        Hero hero = setUpNewHero();
        assertEquals(33, hero.getAge());
    }


    @Test
    void getName() {
        Hero hero = setUpNewHero();
        assertEquals("Superman", hero.getName());
    }


    @Test
    void getSuperpower() {
        Hero hero = setUpNewHero();
        assertEquals("Super Strength", hero.getSuperpower());
    }


    @Test
    void getWeakness() {
        Hero hero = setUpNewHero();
        assertEquals("Not human", hero.getWeakness());
    }

}