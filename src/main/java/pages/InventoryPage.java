package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends PageBase{
    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    /*********** Web Elements **********/
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    public
    WebElement addBackpackToCartBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    public
    WebElement removeBackpackFromCartBtn;

    @FindBy(xpath = "//span[@class='shopping_cart_badge']")
    public
    WebElement shoppingCartBadge;

    /********** Page Methods ************/
    public void addBackpackToCart(){
        clickButton(addBackpackToCartBtn);
    }
    public void removeBackpackFromCart(){
        clickButton(removeBackpackFromCartBtn);
    }
}
