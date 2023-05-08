package testClasses;


import org.pageClasses.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;


public class AmazonScenarioTest {
    private static final String USERNAME = "conelin830@larland.com";
    private static final String PASSWORD = "123456789";
    private static final String SEARCH_CATEGORY = "Video Games";
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\WebDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testAmazonScenario() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.open();
        homePage.clickSignInButton();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setEmail(USERNAME);
        loginPage.clickContinueButton();
        loginPage.setPassword(PASSWORD);
        loginPage.clickSignInSubmitButton();
        try {
            Thread.sleep(20000); // wait for 10 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        VideoGamesPage videoGamesPage = new VideoGamesPage(driver);
        videoGamesPage.clickAllVideoGamesLink();
        waitMethod();
        videoGamesPage.expandMenu();
        waitMethod();
        videoGamesPage.clickOnVideoGamesCategory();
        waitMethod();

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.clickShippingFilter();
        productsPage.clickConditionFilter();
        productsPage.clickSortMenu();
        productsPage.clickHighToLowLink();
        productsPage.addProductsToCart();
        List<Double> prices = productsPage.addProductsToCart();

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartButton();
        assertTrue(cartPage.verifyCartItems(prices));

        PaymentPage paymentPage = new PaymentPage(driver);
        paymentPage.clickProceedToCheckoutButton();
        paymentPage.clickContinueButton2();
        paymentPage.clickContinueButton3();
        paymentPage.clickCashOnDeliveryRadioButton();
        paymentPage.clickContinueButton4();
        double totalAmount = paymentPage.getTotalAmount();

        assertEquals(prices.stream().mapToDouble(Double::doubleValue).sum(), totalAmount, 0.0);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    public void waitMethod()
    {
        try {
            Thread.sleep(1000); // wait for 1 second
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}