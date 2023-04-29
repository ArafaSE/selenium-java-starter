package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;


public class TC1_Login extends BaseTest {
    @Test
    public void user_login_with_valid_credentials() {
        loginPage = new LoginPage();
        loginPage.login("standard_userhamada", "secret_sauce");

        Assert.assertEquals(getCurrentURL(), getHomURL() + "/inventory.html");
    }
}
