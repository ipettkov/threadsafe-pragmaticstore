package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import enums.Password;
import enums.Username;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.testng.Assert.*;

/**
 * The class represents the Admin Login Page
 */

public class AdminLoginPage extends ParentPage {
    private static final By USERNAME_FIELD = By.id("input-username");
    private static final By PASSWORD_FIELD = By.id("input-password");
    private static final By LOGIN_BUTTON = By.cssSelector(".btn-primary");
    private static final By LOGIN_VALIDATION_ERROR = By.cssSelector(".alert-danger");
    private static final By INVALID_TOLKEN_LOC = By.cssSelector("button[class=close][type='button']");
    private final static String[][] LOGIN_DATA_DRIVEN_DATA = {
            new String[] {"wrong user", "parola123!", "No match for Username and/or Password."},
            new String[] {"admin", "wrongpassword", "No match for Username and/or Password."},
            new String[] {"wrongUsername", "wrongpassword", "No match for Username and/or Password."},
            new String[] {"", "", "No match for Username and/or Password."}
    };

    public AdminLoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method Logs in into admin dashboard page accepting from the enum classes Password and Username as paramters
     * @param username accepts paramter from Enum class Username
     * @param password accepts paramter from Enum class Password
     * @see Username
     * @see Password
     */

    public void login(Username username, Password password) {
        type(USERNAME_FIELD, username.getUsername());
        type(PASSWORD_FIELD, password.getPassword());
        click(LOGIN_BUTTON);
    }

    /**
     * Method designed for negative Login data driven tests accepting Strings in order for the data provider to fill them with multiple variants
     * @param username accepts String
     * @param password accepts String
     */

    public void loginDDT(String username, String password) {
        type(USERNAME_FIELD, username);
        type(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);
    }

    /**
     * Method that provides the specified input data to the @DataProvider for the Data driven negative log in test
     * @return returns String[][] with the data specified in LOGIN_DATA_DRIVEN_DATA constant in AdminLoginPage class
     */

    public Object[][] getTestData() {
        return LOGIN_DATA_DRIVEN_DATA;
    }

    /**
     * Method clears login fields
     */

    public void clearLoginFields() {
        clear(USERNAME_FIELD);
        clear(PASSWORD_FIELD);
    }

    /**
     * Method verifies whether the actual login error message matches the expected one
     * @param expectedMessage
     */

    public void verifyErrorValidationMessage(String expectedMessage) {
        String errorMsg = getElementText(LOGIN_VALIDATION_ERROR);
        assertTrue(errorMsg.contains(expectedMessage));
    }

    /**
     * Method clears the Invalid Tolken session error if it appears to prevent the negative login Data driven test interruption
     */

    public void clearInvalidTolken() {
        if (isElementPresent(INVALID_TOLKEN_LOC)) {
            getElement(INVALID_TOLKEN_LOC).click();
        }
    }
}

