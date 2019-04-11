package com.tools.qa.facade;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Month;

public class DatePicker {

//    private static final Logger log = Logger.getLogger(DatePicker.class);

    private WebElement selfElement;

    public DatePicker(WebElement calendar) {
        this.selfElement = calendar;
    }

    public void chooseDate(String text) {
        String [] date = text.split("/");
        String day =  getFirstNumber(date[1]);
        String monthNumber = getFirstNumber(date[0]);
        String monthName = defineMonthNameFromNumber(monthNumber);
        int year = Integer.parseInt(date[2]);
        if (!isFormExists()) {
            selfElement.click();
        }
        selectMonth(monthName);
        selectYear(year);
        selectDay(day);
    }

    private String getFirstNumber(String number) {
        return (number.startsWith("0")) ? number.substring(1,2) : number;
    }

    private String defineMonthNameFromNumber(String month) {
        String mont = Month.of(Integer.parseInt(month)).toString().substring(0,3);
        String first = mont.substring(0,1);
        String last = mont.substring(1,3).toLowerCase();
        return first.concat(last);
    }

    private void selectDay(String day) {
        selfElement.findElement(By.xpath(String.format("//div/descendant::span[text()='%s']", day))).click();
    }

    private boolean isFormExists() {
        return !selfElement.findElements(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div/div")).isEmpty();
    }

    private int getActualYear() {
        return Integer.parseInt(selfElement.findElement(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div[1]/div[1]/div/span[3]")).getText());
    }

    private void selectYear(int expectedYear) {
//        log.info(String.format("selected %d year", expectedYear));
        do {
            if (expectedYear > getActualYear()) {
                selfElement.findElement(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div[1]/div[1]/span[4]")).click();
            }
            if (expectedYear < getActualYear()) {
                selfElement.findElement(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div[1]/div[1]/span[2]")).click();
            }
            if (expectedYear == getActualYear()) {
                break;
            }
        } while (expectedYear != getActualYear());
    }

    private void selectMonth(String month) {


//        log.info(String.format("selected %s month", month));
        do {
            if (!getActualMonth().equals(month)) {
                selfElement.findElement(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div[1]/div[1]/span[1]")).click();
            }
            if (getActualMonth().equals(month)) {
                break;
            }
        }
        while (!getActualMonth().equals(month));
    }

    private String getActualMonth() {
        return selfElement.findElement(By.xpath("//div[@class='App']/div[2]/div[3]/div[2]/div[1]/div[1]/div/span[2]")).getText();
    }

}
