package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Login extends TestBase{
    @Test(priority = 1)
    public void user_login_with_valid_credentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL + "/inventory.html");
    }
}
