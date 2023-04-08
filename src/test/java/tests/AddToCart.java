package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCart extends TestBase{
    @Test
    public void user_can_add_product_to_his_cart() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL + "/inventory.html");

        InventoryPage inventoryPage = new InventoryPage(driver);

        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), "1");
        Assert.assertTrue(inventoryPage.removeBackpackFromCartBtn.isDisplayed());

        inventoryPage.removeBackpackFromCart();
        Assert.assertTrue(inventoryPage.addBackpackToCartBtn.isDisplayed());
    }
}
