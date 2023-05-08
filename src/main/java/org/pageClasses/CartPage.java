package org.pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage extends BasePage {
    private static final By CART_BUTTON_LOCATOR = By.id("nav-cart");
    private static final By CART_ITEMS_LOCATOR = By.xpath("//div[@data-name='Active Items']//div[@class='a-row sc-list-item sc-list-item-border']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void clickCartButton() {
        click(CART_BUTTON_LOCATOR);
    }

    public boolean verifyCartItems(List<Double> prices) {
        List<WebElement> cartItems = driver.findElements(CART_ITEMS_LOCATOR);
        return cartItems.size() == prices.size();
    }
}