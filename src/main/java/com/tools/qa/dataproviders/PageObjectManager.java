package com.tools.qa.dataproviders;

import com.tools.qa.pageobjects.ArchivePage;
import com.tools.qa.pageobjects.CartPage;
import com.tools.qa.pageobjects.CheckoutPage;
import com.tools.qa.pageobjects.HomePage;
import com.tools.qa.pageobjects.ManageOpcodePage;
import com.tools.qa.pageobjects.ProductListingPage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;
    private ProductListingPage productListingPage;
    private HomePage homePage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ManageOpcodePage manageOpcodePage;
    private ArchivePage archivePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductListingPage getProductListingPage() {
        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
    }

    public CartPage getCartPage() {
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }

    public ManageOpcodePage getManageOpcodePage(){
        return (manageOpcodePage == null) ? manageOpcodePage = new ManageOpcodePage(driver) : manageOpcodePage;
    }

    public ArchivePage getArchivePage(){
        return (archivePage == null) ? archivePage = new ArchivePage(driver) : archivePage;
    }
}
