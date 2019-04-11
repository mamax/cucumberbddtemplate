package com.tools.qa.pageobjects;

import com.tools.qa.facade.DatePicker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ArchivePage extends AbstractPage {

    public ArchivePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='hostName']")
    private WebElement enterHostOpcodesArea;

    public WebElement getCalendarWidget() {
        return calendarWidget;
    }

    @FindBy(xpath = "//div[@class='App']/div[2]/div[3]/div[2]")
    private WebElement calendarWidget;

    public void setHost(String host) {
        enterHostOpcodesArea.clear();
        enterHostOpcodesArea.sendKeys(host);
    }

    public void clickOnCalendarWidget() {
        calendarWidget.click();
    }

    public void selectDate(String date) {
        new DatePicker(getCalendarWidget()).chooseDate(date);
    }
}
