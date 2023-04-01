package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCart extends TestBase{
    @Test(priority = 2)
    public void user_can_add_product_to_his_cart() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL + "/inventory.html");

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        Assert.assertEquals(driver.findElement(By.id("remove-sauce-labs-backpack")).getText(), "Remove");
        Assert.assertEquals(driver.findElement(By.xpath("//span[@class='shopping_cart_badge']")).getText(), "1");

    }
}
