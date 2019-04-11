package com.tools.qa.pageobjects;

import com.tools.qa.util.WaitHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends AbstractPage{

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".cart-button")
    private WebElement btn_Cart;

    @FindBy(how = How.CSS, using = ".checkout-button.alt")
    private WebElement btn_ContinueToCheckout;


    public void clickOn_Cart() {
        btn_Cart.click();
    }

    public void clickOn_ContinueToCheckout(){
        btn_ContinueToCheckout.click();
        WaitHelper.untilJqueryIsDone(driver);
    }
}
