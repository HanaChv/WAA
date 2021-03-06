package pages;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GosslingatorPage {
@FindBy(id = "addRyan")
   WebElement addRyanButton;
    WebDriver pageDriver;

    public GosslingatorPage(WebDriver driver) {
        this.pageDriver = driver;
    }

    public void addRyan() {
        WebElement ryanButton = pageDriver.findElement(By.id("addRyan"));
        ryanButton.click();
    }
    public void addRyan() {
        WebElement ryanButton = pageDriver.findElement(By.id("addRyan"));
        ryanButton.click();
    }

    public String getRyanCounterNumber() {
        return pageDriver.findElement(By.id("ryanCounter")).getText();
    }

    public String getCounterDescription() {
//        vrati napis Ryan alebo Ryans
        return pageDriver.findElement(By.cssSelector("div.ryan-counter h3")).getText();
    }

    public int getNumberOfRyanImages(){
        return pageDriver.findElements(By.cssSelector("img")).size();
    }
}
