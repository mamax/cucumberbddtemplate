package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.pageobjects.CartPage;
import cucumber.api.java.en.And;

public class CartPageSteps {
    CartPage cartPage;
    TestContext testContext;

    public CartPageSteps(TestContext testContext) {
        this.testContext = testContext;
        cartPage = testContext.getPageObjectManager().getCartPage();
    }

    @And("^moves to checkout from mini cart$")
    public void movesToCheckoutFromMiniCart() throws Throwable {
        cartPage.clickOn_Cart();
        cartPage.clickOn_ContinueToCheckout();
    }
}
