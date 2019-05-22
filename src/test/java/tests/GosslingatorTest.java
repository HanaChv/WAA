package tests;

import base.TestBase;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.GosslingatorPage;

public class GosslingatorTest extends TestBase {
    private GosslingatorPage gossPage;
    private String actualNumberOfRyans; //private = viditelna len pre triedu

    //    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        //0.spustit prehliadac
//        WebDriver driver = new ChromeDriver();
//        //1.otvorit stranku
//        driver.get("http://localhost/gosslingator.php");
//    }

    @Before
    public void openPage() {
        System.setProperty("webdriver.chrome.driver", "chromedriver74.exe");
        //spustit prehliadac
        driver = new ChromeDriver();
        //otvorit stranku
        driver.get(BASE_URL + "/gosslingator.php");
        gossPage = new GosslingatorPage(driver)
    }

    @After
    public void tearDown() {
        //zatvorit prehliadac
        driver.close();
        //ukoncit session
        driver.quit();
    }

    @Test
    public void itShouldAddOneRyan() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("addRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        driver.findElement(By.id("removeRyan")).click();
        Assert.assertEquals("1", gossPage.getRyanCounterNumber());
        System.out.println("Number of ryans: " + driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        Assert.assertEquals("ryan", gossPage.getCounterDescription());
    }

    @Test
    public void itShouldAddTwoRyans() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        //2.kliknut na tlacidlo
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        gossPage.addRyan();
        gossPage.addRyan();
        gossPage.addRyan();
        driver.findElement(By.id("removeRyan")).click();
        //3.overit pocitanie Ryanov
        String actualNumberOfRyan = driver.findElement(By.cssSelector("div.ryan-counter h2")).getText();
        String actualRyanDescription = gossPage.getCounterDescription();
        Assert.assertEquals("2", actualNumberOfRyan);
        Assert.assertEquals("ryans", actualRyanDescription);
    }

    @Test
    public void itShouldDisplayTitle() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        System.out.println(driver.findElement(By.cssSelector("h1.ryan-title")).getText());
        Assert.assertEquals("GOSLINGATE ME", driver.findElement(By.cssSelector("h1.ryan-title")).getText());

    }

    @Test
    public void itShouldGetTooManyRyans() {
        GosslingatorPage gossPage = new GosslingatorPage(driver);
        //2.kliknut na tlacidlo
        //ALT+J oznacenie kazdeho dalsieho vyskytu
        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
        for (int i = 0; i < 50; i++) {
            gossPage.addRyan();
            String actualNumberOfRyans = gossPage.getRyanCounterNumber();
            Assert.assertEquals(String.valueOf(i + 1), actualNumberOfRyans);

            //overit sklonovanie pomocou podmienky
            String actualDescription = gossPage.getCounterDescription();
            if (i + 1 == 1) {
                Assert.assertEquals("ryan", actualDescription);
            }
            if (i + 1 >= 2) {
                Assert.assertEquals("ryans", actualDescription);
            }
//overím počet obrázkov Ryana
            int numberOfRyanImages = gossPage.getNumberOfRyanImages();
            Assert.assertEquals(i + 1, numberOfRyanImages);

            System.out.println("index i = " + 1);
            System.out.println("pocet ryanov = " + actualNumberOfRyans);
        }

        //3.overit pocitanie Ryanov
        Assert.assertEquals(
                "NUMBER OF\n" +
                        "RYANS\n" +
                        "IS TOO DAMN\n" +
                        "HIGH"
                , driver.findElement(By.cssSelector("h1.tooManyRyans")).getText());
        //System.out.println(driver.findElement(By.cssSelector("h1.tooManyRayns")).getText());
        //System.out.println(driver.findElement(By.cssSelector("div.ryan-counter h2")).getText());
        //driver.findElement()
    }

//    @Test
//    public void itShouldGetTooManyRyansUsingWhileCycle() {
//        WebElement addRyanButton = driver.findElement(By.id("addRyan"));
//        String actualNumberOfRyans = driver.findElement(By.id("ryanCounter")).getText();
//        //while cyklus sa vykona vzdy ak je podmienka "true"
//        int clicksLimit = 30;
//        int clicks = 0;
//        //ktora podmienka sa splni? bud alebo (true ak plati aspon jedna z oboch podmienok)
//        while (!actualNumberOfRyans.equals("50") || clicks <= clicksLimit) {
//            addRyanButton.click();
//            addRyanButton = driver.findElement(By.id("ryan.Counter")).getText();
//            clicks++;
//        }

    //       // @Test
//        public void itShouldDisplayNoRyanOnPageOpen() {
//            Assert.assertFalse(driver.findElement());
//        }

//        //ktora podmienka sa splni? a sucasne!! (truew ak platia obidve podmienky)
//            while (!actualNumberOfRyans.equals("50")&& clicks < clicksLimit){
//                addRyanButton.click();
//                addRyanButton = driver.findElement(By.id("ryan.Counter")).getText();
//                clicks++;
}