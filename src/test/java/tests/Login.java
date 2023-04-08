package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class Login extends TestBase{
    @Test
    public void user_login_with_valid_credentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("standard_user", "secret_sauce");

        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL + "/inventory.html");
    }
}
