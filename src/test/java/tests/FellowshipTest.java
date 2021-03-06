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

import java.util.ArrayList;
import java.util.List;

public class FellowshipTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/fellowship.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldContainNameForEachFellow() {
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        System.out.println("wefwef");

        for (WebElement fellowElement : fellowElements) {
//System.out.println(fellowElement.findElement(By.cssSelector("ul.list-of-fellows li h1")).getText());
//WebElement fellowName = fellowElement.findElement(By.cssSelector("ul.list-of-fellows li h1"));
            Assert.assertFalse(fellowElement.findElement(By.cssSelector("h1")).getText().isEmpty());

        }
    }

    @Test
    public void itShouldContainSpecifiedFellows() {
        List<WebElement> fellowElements = driver.findElements(By.cssSelector("ul.list-of-fellows li"));
        List<String> fellowNames = new ArrayList<String>();
        for (WebElement fellowElement : fellowElements) {
//            v ramci kazdej kachlicky si najdem meno a to ulozim do zoznamu mien
            fellowNames.add(fellowElement.findElement(By.cssSelector("h1")).getText());
        }
        System.out.println(fellowNames);
//        over, že list obsahuje Gandalf-a a Aragorn-a
        Assert.assertTrue(fellowNames.contains("Gandalf"));
        Assert.assertTrue(fellowNames.contains("Aragorn"));
        Assert.assertTrue(fellowNames.contains("Frodo"));
    }

    private void selectPokemon(String pokemonToSelect) {
//        tato metoda bude prijimat jeden vstupny parameter, ktory je string
        WebElement pokemonSelect = driver.findElement(By.cssSelector("select"));
        new Select(pokemonSelect).selectByVisibleText(pokemonToSelect);
    }

    private String getActualMessage() {
        return driver.findElement(By.cssSelector("div.pokemon h3")).getText();
    }

    private String getExpectedMessage(String pokemonName) {
        return String.format("I choose you %s !", pokemonName);
    }
}
