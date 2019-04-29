package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathTrainingTests {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/xpathtrainingcenter.php");
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldCheckSecondbutton() {
        String buttonText = "Second button";
        //2.vypisat meno z predposledneho riadku
        driver.findElement(By.xpath("//button[2]")).click();
        //driver.findElement(By.xpath("//button[contains(text(), "Second button"))]")).click();
        String actualMessage2 = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        //System.out.println("Text v poli Acation: " + driver.findElement(By.cssSelector("div.output h2 span")).getText());
        Assert.assertEquals(
                "you clicked " + buttonText.toLowerCase(),
                actualMessage2
        );
    }

    @Test
    public void itSchouldDisplayEnteredMessage() {
        String message = "vonku prší";
        driver.findElement(By.cssSelector("input")).sendKeys(message);
        //stlacim tlacidlo Hit me!
        driver.findElement(By.id("hitme")).click();
        String actualMessage = driver.findElement(By.cssSelector("div.output h2 span")).getText();
        //overim hlasku
        Assert.assertEquals(
                "you entered " + message,
                actualMessage);
    }
}
