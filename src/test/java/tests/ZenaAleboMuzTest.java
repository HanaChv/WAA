package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZenaAleboMuzTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/zenaalebomuz.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldCheckNoRadioChoosen() {
        //zadam zakladne udaje
      //  Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
     //   Assert.assertFalse(driver.findElement(By.xpath("//input[@value='wurst']")).isSelected());
    }

    @Test
    public void imageShouldBeDisplayed(){

    }
}
