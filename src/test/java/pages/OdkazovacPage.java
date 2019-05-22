package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.openqa.selenium.By.cssSelector;

public class OdkazovacPage {
    WebDriver driver;

    private void submitNewNote() {
        driver.findElement(cssSelector("button.btn-block")).click();
    }

    private void checkNoteDetail(String title, String author, String message) {
        WebElement detail = driver.findElement()
    }
}
