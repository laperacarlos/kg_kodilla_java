package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacebookTestingApp {
    public static final String XPATH_ACCEPT_COOKIES = "//div[contains(@class, \"_9o-r\")]/button[2]";
    public static final String XPATH_CREATE_ACCOUNT = "//div[contains(@class, \"_6ltg\")]/a";
    public static final String XPATH_SELECT_DAY = "//div[contains(@class, \"_5k_5\")]/span/span/select[1]";
    public static final String XPATH_SELECT_MONTH = "//div[contains(@class, \"_5k_5\")]/span/span/select[2]";
    public static final String XPATH_SELECT_YEAR = "//div[contains(@class, \"_5k_5\")]/span/span/select[3]";

    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        while (!driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES)).isDisplayed());
        WebElement acceptCookies = driver.findElement(By.xpath(XPATH_ACCEPT_COOKIES));
        acceptCookies.click();

        WebElement createAccount = driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT));
        createAccount.click();

        new WebDriverWait(driver, 2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_SELECT_DAY)));

        WebElement daySelector = driver.findElement(By.xpath(XPATH_SELECT_DAY));
        Select selectDay = new Select(daySelector);
        selectDay.selectByValue("7");

        WebElement monthSelector = driver.findElement(By.xpath(XPATH_SELECT_MONTH));
        Select selectMonth = new Select(monthSelector);
        selectMonth.selectByVisibleText("maj");

        WebElement yearSelector = driver.findElement(By.xpath(XPATH_SELECT_YEAR));
        Select selectYear = new Select(yearSelector);
        selectYear.selectByValue("1984");
    }
}
