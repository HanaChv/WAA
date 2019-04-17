package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GosslingatorTest {

    @Test
    public void itShouldAddOneRyan (){
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/gosslingator.php");
        //2.kliknut na tlacidlo
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov
                Assert.assertEquals( "1", driver.findElement(By.id("ryanCounter")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();
        //čo je to "trieda"??
        //čo je to "driver"??
        //.get (tak ako v Python :-)
        //Test failed nemame nainstalovany spravny driver - moja verzia google chrome je 73.atd - stiahnut spravnu verziu
    }
}
