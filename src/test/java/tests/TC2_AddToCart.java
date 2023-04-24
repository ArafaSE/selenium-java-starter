package tests;

import org.testng.Assert;
import org.testng.annotations.*;
import pages.InventoryPage;
import pages.LoginPage;

public class TC2_AddToCart extends BaseTest {
    LoginPage loginPage;
    InventoryPage inventoryPage;

    @BeforeMethod
    public void initTest(){
        loginPage = new LoginPage();
        inventoryPage = loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(getCurrentURL(), getHomURL() + "/inventory.html");
    }
    @Test
    public void user_can_add_product_to_his_cart() {
        inventoryPage.addBackpackToCart();
        Assert.assertEquals(inventoryPage.getShoppingCartBadgeText(), "1");
        Assert.assertTrue(inventoryPage.isRemoveBackpackFromCartBtnDisplayed());
    }
    @Test
    public void user_can_remove_product_from_his_cart() {
        inventoryPage.removeBackpackFromCart();
        Assert.assertTrue(inventoryPage.isAddBackpackToCartBtnDisplayed());
    }
}
