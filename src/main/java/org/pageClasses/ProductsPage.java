package org.pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class ProductsPage extends BasePage {
    private void click(WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().build().perform();
    }
    private static final By SHIPPING_FILTER_LOCATOR = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[9]");
    private static final By CONDITION_FILTER_LOCATOR = By.xpath("(//i[@class='a-icon a-icon-checkbox'])[10]");
    private static final By SORT_MENU_LOCATOR = By.xpath("(//span[@class='a-button-text a-declarative'])");
    private static final By HIGH_TO_LOW_LINK_LOCATOR = By.xpath("//a[@class='a-dropdown-link' and contains(text(), 'Price: High to Low')]");
    private static final double MAX_PRICE = 15000;

    private static final By OPEN_PRODUCT_LOCATOR = By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']");
    //List<WebElement> addToCartButtons = driver.findElements(By.xpath(".//input[@value='Add to Cart']"));
    private static final By ADD_TO_CART_BUTTON_LOCATOR = By.xpath(".//input[@value='Add to Cart']");
    private static final By CLOSE_BUTTON_LOCATOR = By.xpath("//div[@id='attach-close_sideSheet-link']//i[@class='a-icon a-icon-close']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void clickShippingFilter() {
        click(SHIPPING_FILTER_LOCATOR);
    }

    public void clickConditionFilter() {
        click(CONDITION_FILTER_LOCATOR);
    }

    public void clickSortMenu() {
        click(SORT_MENU_LOCATOR);
    }

    public void clickHighToLowLink() {
        click(HIGH_TO_LOW_LINK_LOCATOR);
    }

    public List<Double> addProductsToCart() throws InterruptedException {
        List<Double> prices = new ArrayList<>();

        List<WebElement> productElements = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
        Thread.sleep(1000);
        for (WebElement productElement : productElements) {
            Thread.sleep(1000);
            try {
                WebElement priceElement = productElement.findElement(By.xpath(".//span[@class='a-price-whole']"));
                double price = Double.parseDouble(priceElement.getText().replace(",", ""));
                if (price <= MAX_PRICE) {
                    WebElement openProductButton = productElement.findElement(By.xpath(".//h2/a"));
                    click(openProductButton);
                    Thread.sleep(500);
                    List<WebElement> addToCartButtons = driver.findElements(By.xpath(".//input[@value='Add to Cart']"));
                    if (addToCartButtons.size() > 0) {
                        click(ADD_TO_CART_BUTTON_LOCATOR);
                        driver.navigate().back();
                        driver.navigate().back();
                    }
                    else
                        driver.navigate().back();
                }
                prices.add(price);
            } catch (Exception e) {
                // Ignore any products without a price
            }
        }

        return prices;
    }
}