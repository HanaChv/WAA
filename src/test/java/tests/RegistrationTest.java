package tests;

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
        String email = "brano@mojsej.sk";
        String meno = "branislav";
        String priezvisko = "mojsej";
        String heslo = "123456";

        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement((By.name("name")).sendKeys(meno);
        driver.findElement((By.name("surname")).sendKeys(priezvisko);
        driver.findElement((By.name("password")).sendKeys(heslo);
        driver.findElement((By.name("password-repeat")).sendKeys(heslo);
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
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger"))).isDisplayed(
        );
    }
}
