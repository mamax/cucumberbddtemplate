package com.tools.qa.stepdefs;

import com.tools.qa.pageObjects.CartPage;
import com.tools.qa.pageObjects.CheckoutPage;
import com.tools.qa.pageObjects.HomePage;
import com.tools.qa.pageObjects.PageObjectManager;
import com.tools.qa.pageObjects.ProductListingPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {
    WebDriver driver;
    HomePage homePage;
    ProductListingPage productListingPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    PageObjectManager pageObjectManager;

    @Given("^user is on Home Page$")
    public void userIsOnTheHomePage() throws Throwable{
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.navigateTo_HomePage();
    }

    @When("^he search for \"([^\"]*)\"$")
    public void heSearchForDress(String product) throws Throwable {
        homePage.perform_Search(product);
    }

    @And("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() throws Throwable {
        productListingPage = pageObjectManager.getProductListingPage();
        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();
    }

    @And("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() throws Throwable {
        cartPage = pageObjectManager.getCartPage();
        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
    }

    @And("^enter personal details on checkout page$")
    public void enterPersonalDetailsOnCheckoutPage() throws Throwable {
        checkoutPage = pageObjectManager.getCheckoutPage();
        checkoutPage.fill_PersonalDetails();
    }

    @And("^select same delivery address$")
    public void selectSameDeliveryAddress() throws Throwable {
        checkoutPage.check_ShipToDifferentAddress(false);
    }

    @And("^select payment method as \"([^\"]*)\" payment$")
    public void selectPaymentMethodAsCheckPayment(String buttonName) throws Throwable {
        checkoutPage.select_PaymentMethod(buttonName);
    }

    @And("^place the order$")
    public void placeTheOrder() throws Throwable {
        checkoutPage.check_TermsAndCondition(true);
        checkoutPage.clickOn_PlaceOrder();

        driver.quit();
    }
}

