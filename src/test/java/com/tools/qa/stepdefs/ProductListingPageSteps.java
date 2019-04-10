package com.tools.qa.stepdefs;

import com.tools.qa.cucumber.TestContext;
import com.tools.qa.pageobjects.ProductListingPage;
import cucumber.api.java.en.And;

public class ProductListingPageSteps {

    ProductListingPage productListingPage;
    TestContext testContext;

    public ProductListingPageSteps(TestContext testContext) {
        this.testContext = testContext;
        productListingPage = testContext.getPageObjectManager().getProductListingPage();
    }

    @And("^choose to buy the first item$")
    public void chooseToBuyTheFirstItem() throws Throwable {
        productListingPage.select_Product(0);
        productListingPage.clickOn_AddToCart();
    }
}
