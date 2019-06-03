package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import pages.RegistrationPage;

public class RegistrationTest extends TestBase {

    @Before
    public void openPage() {
        driver.get("/registracia.php");
    }

    @Test
    public void itShouldRegisterValidUser() {
        String email = "brano@mojsej.sk";
        String meno = "brano";
        String priezvisko = "mojsej";
        String heslo = "123456";

        //zadam zakladne udaje
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.enterData(email, meno, priezvisko, heslo);
//        Fairy fairy = Fairy.create();
//        Person person = fairy.person();

//        driver.findElement(By.name("email")).sendKeys(person.getEmail());
//        driver.findElement(By.name("name")).sendKeys(person.getFirstName());
//        driver.findElement(By.name("surname")).sendKeys(person.getLastName());
//        driver.findElement(By.name("password")).sendKeys(person.getPassword());
//        driver.findElement(By.name("password-repeat")).sendKeys(person.getPassword());

        driver.findElement(By.id("checkbox")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-success")).isDisplayed());
    }

    @Test
    public void itShouldDisplayErrorMessageWhenInputsAreEmpty() {
        driver.findElement(By.name("robot")).click();
        driver.findElement(By.cssSelector("button.btn-success")).click();
        Assert.assertTrue(driver.findElement(By.cssSelector("div.alert-danger")).isDisplayed());
    }
}
