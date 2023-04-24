package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
    /*********** Web Elements **********/
    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");

    /********** Page Methods ************/
    public InventoryPage login(String username, String password){
        setText(usernameInput, username);
        setText(passwordInput, password);
        click(loginBtn);
        return new InventoryPage();
    }
}
