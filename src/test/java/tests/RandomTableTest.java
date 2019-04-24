package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RandomTableTest {
    @Test
    public void itShouldPrintLastRow() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        //0.spustit prehliadac
        WebDriver driver = new ChromeDriver();
        //1.otvorit stranku
        driver.get("http://localhost/tabulka.php");
        //2.vypisat meno z predposledneho riadku
        System.out.println("Meno v poslednom riadku: " + driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();
    }

}
