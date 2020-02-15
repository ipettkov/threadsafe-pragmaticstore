package bg.pragmatic.core.pages.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * The class wraps the driver state from the main operational App class and provides general methods for its child classes(pages)
 */
public class ParentPage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public ParentPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Method clicks on an element located by a locator
     * @param locator - accepts By
     */
    protected void click(By locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        driver.findElement(locator).click();
    }

    /**
     * Method types the passed text in a selected field
     * @param locator - accepts By
     * @param textToType - accepts String
     */
    protected void type(By locator, String textToType) {
        waitForElement(locator);
        driver.findElement(locator).sendKeys(textToType);
    }

    /**
     * This method clears a specified text field element
     * @param locator - accepts By
     */
    protected void clear(By locator) {
        waitForElement(locator);
        driver.findElement(locator).clear();
    }

    /**
     * Method that checks if a certain element is displayed
     * @param locator - accepts By
     * @return returns boolean
     */
    protected boolean isDisplayed(By locator) {
        waitForElement(locator);
        return !driver.findElements(locator).isEmpty();
    }

    /**
     * Method that gets the text from specified element
     * @param locator - accepts By
     * @return returns String
     */
    protected String getElementText(By locator) {
        waitForElement(locator);
        return driver.findElement(locator).getText();
    }

    /**
     * Method that gets element and returns WebElement
     * @param locator - accepts By
     * @return returns WebElement
     */
    protected WebElement getElement(By locator) {
        waitForElement(locator);
        return driver.findElement(locator);
    }

    /**
     * Method that gets a collection of Elements
     * @param locator - accepts By
     * @return returns List<WebElements></>
     */
    protected List<WebElement> getElements(By locator) {
        wait = new WebDriverWait(driver, 10);
        wait.until(webDriver -> !webDriver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    /**
     * Method checks if the passed as the param locator element is present
     * @param locator
     * @return
     */
    protected boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Method which verifies that the passed as the parameter locator, dropdown menu options are matching the expected number,
     * passed as the expectedNumber parameter and returns a massage passed as the massageIfMismatch param if they mismatch.
     * @param locator - accepts By
     * @param expectedNumber - accepts int
     * @param messageIfMismatch - accepts String
     */
    public void verifyOptionsNumber(By locator, int expectedNumber, String messageIfMismatch) {
        Select dropDownMenu = new Select(getElement(locator));
        Assert.assertEquals(dropDownMenu.getOptions().size(), expectedNumber, messageIfMismatch);
    }

    /**
     * Method that compares the content of the selected by the parameter getDropDownMenu, dropdown menu in Orders page with an expected array
     * of options passed as the parameter expectedOptions
     * @param getDropDownMenu - accepts By
     * @param expectedOptions - accepts non-fixed number ot Strings and generates an array filled with them
     */
    public void verifyDropDownMenuContent(By getDropDownMenu, String... expectedOptions) {
        Select dropDown = new Select(getElement(getDropDownMenu));
        List<String> exp_options = Arrays.asList(expectedOptions);
        List<String> act_options = new ArrayList<>();
        dropDown.getOptions().forEach(options -> act_options.add(options.getText()));
        Assert.assertEquals(act_options, exp_options, "Actual and expected options mismatch");
    }

    /**
     * Method that waits for a specified element to be displayed
     * @param element - accepts By
     */
    protected void waitForElement(By element) {
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(webDriver -> webDriver.findElement(element).isDisplayed());
    }
}
