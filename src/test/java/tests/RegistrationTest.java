package tests;

import io.codearte.jfairy.Fairy;
import io.codearte.jfairy.producer.person.Person;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistrationTest {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/registracia.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldRegisterValidUser() {
        Fairy fairy = Fairy.create();
        Person person = fairy.person();

        driver.findElement(By.name("email")).sendKeys(person.getEmail());
        driver.findElement(By.name("name")).sendKeys(person.getFirstName());
        driver.findElement(By.name("surname")).sendKeys(person.getLastName());
        driver.findElement(By.name("password")).sendKeys(person.getPassword());
        driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());
        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();
//overit uspesnu hlasku
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
       //Assert.assertFalse(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
        }
@Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty(){
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}
