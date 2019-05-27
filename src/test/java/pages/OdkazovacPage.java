package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.openqa.selenium.By.cssSelector;

public class OdkazovacPage {

    @FindBy(name = "title")
    //anotacia
    private WebElement titleInput;

    @FindBy(name = "author")
    private WebElement authorInput;

    @FindBy(name = "message")
    private WebElement messageInput;

    @FindBy(css = "button.btn-block")
    private WebElement submitButton;

    private WebDriver pageDriver;

    public OdkazovacPage(WebDriver driver) {
        this.pageDriver = driver;
        PageFactory.initElements(pageDriver, this);
    }

    private void checkNoteDetail(Note noteToCheck) {
        WebElement detail = pageDriver.findElement(By.cssSelector("div.content"));
        Assert.assertEquals(noteToCheck.getTitle(), detail.findElement(By.cssSelector("h4.title")).getText());
        Assert.assertEquals(noteToCheck.getAuthor(), detail.findElement(By.cssSelector("h4.recepient")).getText());
        Assert.assertEquals(noteToCheck.getMessege(), detail.findElement(By.cssSelector("p")).getText());
                ))

        );
    }
}
