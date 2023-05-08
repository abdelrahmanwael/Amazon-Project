package org.pageClasses;import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    private static final String AMAZON_URL = "https://www.amazon.com/";
    private static final By SIGN_IN_BUTTON_LOCATOR = By.id("nav-link-accountList");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(AMAZON_URL);
    }

    public void clickSignInButton() {
        click(SIGN_IN_BUTTON_LOCATOR);
    }
}