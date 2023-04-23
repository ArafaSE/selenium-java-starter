package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.LoginPage;

public class AddToCart extends TestBase{
    LoginPage loginPage;
    InventoryPage inventoryPage;
    @BeforeClass
    public void initTest(){
        loginPage = new LoginPage(driver);

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(), HOME_URL + "/inventory.html");

        inventoryPage = new InventoryPage(driver);
    }
    @Test
    public void user_can_add_product_to_his_cart() {
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.shoppingCartBadge.getText(), "1");
        Assert.assertTrue(inventoryPage.removeBackpackFromCartBtn.isDisplayed());
    }
    @Test
    public void user_can_remove_product_from_his_cart() {
        inventoryPage.removeBackpackFromCart();
        Assert.assertTrue(inventoryPage.addBackpackToCartBtn.isDisplayed());
    }
}
