package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.pageobjects.CheckoutPage;
import cucumber.api.java.en.And;

public class CheckoutPageSteps {
    TestContext testContext;
    CheckoutPage checkoutPage;

    public CheckoutPageSteps(TestContext testContext) {
        this.testContext = testContext;
        checkoutPage = testContext.getPageObjectManager().getCheckoutPage();
    }

    @And("^enter personal details on checkout page$")
    public void enterPersonalDetailsOnCheckoutPage() throws Throwable {
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

        testContext.getWebDriverManager().closeBrowser();
    }
}
