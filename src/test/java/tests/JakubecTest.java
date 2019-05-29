package tests;

import base.TestBase;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class JakubecTest extends TestBase {
@Before
    public void openSpace(){

}

@Test
    public void itShouldDisplayImage() throws InterruptedException {
    driver.findElement(By.id("showHim")).click();
    new WebDriverWait(driver, 10.).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("img.superstar")));
    Assert.assertTrue(driver.findElement(By.cssSelector("img.supertar")));
}
}
