package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RandomTableTest {
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get("http://localhost/tabulka.php");
    }

    @Test
    public void itShouldPrintLastRow() {
        driver.get("http://localhost/tabulka.php");
        //2.vypisat meno z predposledneho riadku
        System.out.println("Meno v poslednom riadku: " + driver.findElement(By.xpath("//table/tbody/tr[last()-1]/td[2]")).getText());
        //4.zatvorit prehliadac
        driver.close();
        //5.ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldContainDataForEachRow() {
        //nova premenna tableRows obsahuje jednotlive riadky tabulky
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            Assert.assertFalse(tableRow.getText().isEmpty());
//        System.out.println(tableRow.getText());
        }
    }

    @Test
    public void itShouldContainNameForEachRow() {
        List<WebElement> tableRows = driver.findElements(By.cssSelector("table tbody tr"));
        for (WebElement tableRow : tableRows) {
            tableRow.findElement(By.cssSelector("td.nth-child(2)"));
//            tableRow.findElement(By.xpath("./td[2]"));
            WebElement rowName = tableRow.findElement(By.xpath("./td[2]"));
            Assert.assertFalse(rowName.getText().isEmpty());
        }

    }
}

