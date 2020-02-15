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

    public GiftsCertificatePage(WebDriver driver) {
        super(driver);
    }

    public void verifyRadioButtons() {
        WebElement birthdayRadioButt = getElement(BIRTHDAY_RADIO_BUTT);
        WebElement christmasRadioButt = getElement(CHRISTMAS_RADIO_BUTT);
        WebElement generalRadioButt = getElement(GENERAL_RADIO_BUTT);

        if (!birthdayRadioButt.isSelected()) {
            birthdayRadioButt.click();
        }

        assertFalse(christmasRadioButt.isSelected());
        assertFalse(generalRadioButt.isSelected());
        assertTrue(birthdayRadioButt.isSelected());
    }

    public void verifyEmptyFieldsError(String fieldToWriteText, String textToSendInField) {
        WebElement filledField = fieldSelector(fieldToWriteText);
        WebElement checkbox = getElement(CHECKBOX);
        WebElement generalRadioButt = getElement(GENERAL_RADIO_BUTT);

        if (!checkbox.isSelected()) {
            checkbox.click();
        }

        if (!generalRadioButt.isSelected()) {
            generalRadioButt.click();
        }

        filledField.sendKeys(textToSendInField);
        getElement(CONTINUE_BUTTON).click();
        List<WebElement> errors = getElements(By.className("text-danger"));

        for (WebElement error : errors) {
            if (error != filledField) {
                assertTrue(error.isDisplayed());
            }
        }
    }

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
