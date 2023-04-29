package pages;

import org.openqa.selenium.By;

public class InventoryPage extends BasePage {
    /*********** Web Elements **********/
    private By addBackpackToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    private By removeBackpackFromCartBtn = By.id("remove-sauce-labs-backpack");
    private By shoppingCartBadge = By.xpath("//span[@class='shopping_cart_badge']");

    /********** Page Methods ************/
    public void addBackpackToCart(){
        click(addBackpackToCartBtn);
    }
    public void removeBackpackFromCart(){
        click(removeBackpackFromCartBtn);
    }

    public String getShoppingCartBadgeText(){
        return getText(shoppingCartBadge);
    }
    public boolean isRemoveBackpackFromCartBtnDisplayed(){
        return find(removeBackpackFromCartBtn).isDisplayed();
    }
    public boolean isAddBackpackToCartBtnDisplayed(){
        return find(addBackpackToCartBtn).isDisplayed();
    }
}
