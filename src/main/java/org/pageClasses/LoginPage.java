package org.pageClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By EMAIL_FIELD_LOCATOR = By.id("ap_email");
    private static final By CONTINUE_BUTTON_LOCATOR = By.id("continue");
    private static final By PASSWORD_FIELD_LOCATOR = By.id("ap_password");
    private static final By SIGN_IN_SUBMIT_BUTTON_LOCATOR = By.id("signInSubmit");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmail(String email) {
        setText(EMAIL_FIELD_LOCATOR, email);
    }

    public void clickContinueButton() {
        click(CONTINUE_BUTTON_LOCATOR);
    }

    public void setPassword(String password) {
        setText(PASSWORD_FIELD_LOCATOR, password);
    }

    public void clickSignInSubmitButton() {
        click(SIGN_IN_SUBMIT_BUTTON_LOCATOR);
    }
}