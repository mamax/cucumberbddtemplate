package com.tools.qa.pageobjects;

import com.tools.qa.util.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageOpcodePage extends AbstractPage{

    public ManageOpcodePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='selectAllOpcodes1input']/../div")
    private WebElement checkAllChkb;

    public WebElement getCheckAllChkb() {
        return checkAllChkb;
    }

    public void goToTab(String tabName) {
        driver.findElement(By.xpath(String.format("//div[text()='%s']", tabName))).click();
        WaitHelper.untilPageLoadComplete(driver);
    }

    public WebElement getButton(String name) {
        return driver.findElement(By.xpath(String.format("//button[text()='%s']", name)));
    }

    public void checkAllCheckbox() {
        checkAllChkb.click();
    }

}
