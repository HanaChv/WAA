package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PokemonTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/vybersi.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldSelectPikachu() {
       // String selectedPokemon = "Pikachu";
        String[] selectedPokemons = {"Pikachu", "Bulbasaur", "Charmander", "Squirtle", "Diglett", "Geodude"};
        //najdem element select
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        for (String pokemon : selectedPokemons) {
            new Select(pokemonSelect).selectByVisibleText(pokemon);
        }
        //vyberiem pokemona
       // new Select(pokemonSelect).selectByVisibleText(pokemon);
        //overim hlasku
        String actualMessage = driver.findElement(By.cssSelector("div.pokemon h3")).getText();
        String expectedMessage = "I choose you " + pokemon + "!";
        Assert.assertEquals("I choose you " + pokemon + "!", actualMessage);
        Assert.assertEquals(expectedMessage);
    }
}
