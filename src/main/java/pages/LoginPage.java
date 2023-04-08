package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /*********** Web Elements **********/
    @FindBy(id = "user-name")
    WebElement usernameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(id = "login-button")
    WebElement loginBtn;

    /********** Page Methods ************/
    public void login(String username, String password){
        setTextElement(usernameInput, username);
        setTextElement(passwordInput, password);
        clickButton(loginBtn);
    }
}
