package bg.pragmatic.core.pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParentPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    protected void type(By locator, String textToType) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(textToType);
    }

    protected void clear(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    protected boolean isDisplayed(By locator) {
        waitForElement(locator);
        return !driver.findElements(locator).isEmpty();
    }

    protected String getElementText(By locator) {
        waitForElement(locator);
        return driver.findElement(locator).getText();
    }

    protected WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }

    protected List<WebElement> getElements(By locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(webDriver -> !webDriver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void verifyOptionsNumber(By locator, int expectedNumber, String messageIfMismatch) {
        Select dropDownMenu = new Select(getElement(locator));
        Assert.assertEquals(dropDownMenu.getOptions().size(), expectedNumber, messageIfMismatch);
    }

    public void verifyDropDownMenuContent(By getDropDownMenu, String... expectedOptions) {
        Select dropDown = new Select(getElement(getDropDownMenu));
        List<String> exp_options = Arrays.asList(expectedOptions);
        List<String> act_options = new ArrayList<>();
        dropDown.getOptions().forEach(options -> act_options.add(options.getText()));
        Assert.assertEquals(act_options, exp_options, "Actual and expected options mismatch");
    }

    protected void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(webDriver -> webDriver.findElement(element).isDisplayed());
    }
}
