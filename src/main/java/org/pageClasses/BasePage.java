package org.pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        //wait = new WebDriverWait(driver, 10);
    }

    protected WebElement findElement(By locator) {
        return driver.findElement(locator);
    }

    protected void click(By locator) {
        findElement(locator).click();
    }

    protected void setText(By locator, String text) {
        WebElement element = findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return findElement(locator).getText();
    }
}