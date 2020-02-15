package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class GiftsCertificatePage extends ParentPage {
    private final static By BIRTHDAY_RADIO_BUTT = By.cssSelector("div.radio input[value='7']");
    private final static By CHRISTMAS_RADIO_BUTT = By.cssSelector("div.radio input[value='6']");
    private final static By GENERAL_RADIO_BUTT = By.cssSelector("div.radio input[value='8']");
    private final static By RECIPIENT_NAME_INPUT = By.id("input-to-name");
    private final static By RECIPIENT_EMAIL_ADDRESS = By.id("input-to-email");
    private final static By YOUR_NAME_ADDRESS = By.id("input-from-name");
    private final static By YOUR_EMAIL = By.id("input-from-email");
    private final static By CHECKBOX = By.cssSelector("input[type='checkbox']");
    private final static By CONTINUE_BUTTON = By.cssSelector("input[value='Continue'][type='submit']");
    private final static By ERRORS = By.className("text-danger");

    public GiftsCertificatePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Method which checks if the radio buttons in Gifts and Certificates page work
     */
    public void verifyRadioButtons() {

        if (!getElement(BIRTHDAY_RADIO_BUTT).isSelected()) {
            click(BIRTHDAY_RADIO_BUTT);
        }

        assertFalse(getElement(CHRISTMAS_RADIO_BUTT).isSelected());
        assertFalse(getElement(GENERAL_RADIO_BUTT).isSelected());
        assertTrue(getElement(BIRTHDAY_RADIO_BUTT).isSelected());
    }

    /**
     * Method that inputs passed as the param textToSendInField text into the passed as the param textToSendInField and after pressing continue verifies that the expected
     * error messages appear under left empty fields
     * @param fieldToWriteText - accepts String
     * @param textToSendInField - accepts String
     */

    public void verifyEmptyFieldsError(String fieldToWriteText, String textToSendInField) {
        WebElement filledField = fieldSelector(fieldToWriteText);

        if (!getElement(CHECKBOX).isSelected()) {
            click(CHECKBOX);
        }

        if (!getElement(GENERAL_RADIO_BUTT).isSelected()) {
            click(GENERAL_RADIO_BUTT);
        }

        filledField.sendKeys(textToSendInField);
        click(CONTINUE_BUTTON);
        List<WebElement> errors = getElements(ERRORS);

        for (WebElement error : errors) {
            if (error != filledField) {
                assertTrue(error.isDisplayed());
            }
        }
    }
    /**
     * A helper Method for the verifyEmptyFieldsError method which helps the main method to select a field in which to input data.
     */
    private WebElement fieldSelector(String chooseField) {
        WebElement fieldEntry;

        switch (chooseField) {
            case "recipient mail":
                fieldEntry = getElement(RECIPIENT_EMAIL_ADDRESS);
                break;
            case "recipient name":
                fieldEntry = getElement(RECIPIENT_NAME_INPUT);
                break;
            case "name":
                fieldEntry = getElement(YOUR_NAME_ADDRESS);
                break;
            case "email":
                fieldEntry = getElement(YOUR_EMAIL);
                break;
            default:
                throw new RuntimeException("Invalid field name: " + chooseField + " \n Choose between: \n recipient mail, recipient name, name, email");
        }

        return fieldEntry;

    }
}
