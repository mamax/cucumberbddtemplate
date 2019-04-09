package com.tools.qa.stepdefs;

import com.tools.qa.pageObjects.CartPage;
import com.tools.qa.pageObjects.CheckoutPage;
import com.tools.qa.pageObjects.HomePage;
import com.tools.qa.pageObjects.ProductListingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    private HomePage home;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;

    @Given("^user is on Home Page$")
    public void userIsOnTheHomePage() throws Throwable{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.shop.demoqa.com");
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchForDress(String product) throws Throwable {
        home = new HomePage(driver);
        home.perform_Search(product);
    }

    @And("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() throws Throwable {
        productListingPage = new ProductListingPage(driver);
        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();
    }

    @And("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() throws Throwable {
        cartPage = new CartPage(driver);
        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
    }

    @And("^enter personal details on checkout page$")
    public void enterPersonalDetailsOnCheckoutPage() throws Throwable {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.fill_PersonalDetails();
    }

    @And("^select same delivery address$")
    public void selectSameDeliveryAddress() throws Throwable {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.check_ShipToDifferentAddress(false);
    }

    @And("^select payment method as \"([^\"]*)\" payment$")
    public void selectPaymentMethodAsCheckPayment(String buttonName) throws Throwable {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.select_PaymentMethod(buttonName);
    }

    @And("^place the order$")
    public void placeTheOrder() throws Throwable {
        checkoutPage = new CheckoutPage(driver);
        checkoutPage.check_TermsAndCondition(true);
        checkoutPage.clickOn_PlaceOrder();

        driver.quit();
    }
}

