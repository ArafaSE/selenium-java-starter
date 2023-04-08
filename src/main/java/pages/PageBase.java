package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {
    // create constructor
    public PageBase(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    /******** Generic methods *******/
    protected void clickButton(WebElement btn) {
        btn.click();
    }

    protected void setTextElement(WebElement TextElement, String textValue) {
        TextElement.sendKeys(textValue);
    }

    public void clickEnterKey(WebElement enterElement) {
        enterElement.sendKeys(Keys.ENTER);
    }

    protected void waitUntilElementBeVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void waitUntilElementNotVisible(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void waitSec(Integer sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /******** Custom methods, used to reduce the test complexity *******/

}
