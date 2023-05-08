package org.pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BasePage {
    private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR = By.xpath("//input[@name='proceedToRetailCheckout']");
    private static final By CONTINUE_BUTTON_2_LOCATOR = By.xpath("//input[@name='address-ui-widgets-enterAddressFormControls']");
    private static final By CONTINUE_BUTTON_3_LOCATOR = By.xpath("//span[@id='ppw-widgetEvent:Continue-announce']");
    private static final By CASH_ON_DELIVERY_RADIO_BUTTON_LOCATOR = By.xpath("//label[@for='payOnDelivery']");
    private static final By CONTINUE_BUTTON_4_LOCATOR = By.xpath("//button[@name='ppw-widgetEvent:SetPaymentPlanSelectContinueEvent']");
    private static final By TOTAL_AMOUNT_ELEMENT_LOCATOR = By.xpath("//span[@class='a-color-price hlb-price a-inline-block a-text-bold']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public void clickProceedToCheckoutButton() {
        click(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
    }

    public void clickContinueButton2() {
        click(CONTINUE_BUTTON_2_LOCATOR);
    }

    public void clickContinueButton3() {
        click(CONTINUE_BUTTON_3_LOCATOR);
    }

    public void clickCashOnDeliveryRadioButton() {
        click(CASH_ON_DELIVERY_RADIO_BUTTON_LOCATOR);
    }

    public void clickContinueButton4() {
        click(CONTINUE_BUTTON_4_LOCATOR);
    }

    public double getTotalAmount() {
        String totalAmountText = getText(TOTAL_AMOUNT_ELEMENT_LOCATOR).replace(",", "");
        return Double.parseDouble(totalAmountText.substring(3));
    }
}