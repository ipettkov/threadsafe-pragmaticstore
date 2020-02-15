package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import enums.Password;
import enums.Username;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

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

    public void login(Username username, Password password) {
        type(USERNAME_FIELD, username.getUsername());
        type(PASSWORD_FIELD, password.getPassword());
        click(LOGIN_BUTTON);
    }

    public void loginDDT(String username, String password) {
        type(USERNAME_FIELD, username);
        type(PASSWORD_FIELD, password);
        click(LOGIN_BUTTON);
    }

    public String getValidationError() {
        return getElementText(LOGIN_VALIDATION_ERROR);
    }

    public Object[][] getTestData() {
        return LOGIN_DATA_DRIVEN_DATA;
    }

    public void clearLoginFields() {
        clear(USERNAME_FIELD);
        clear(PASSWORD_FIELD);
    }

    public void verifyErrorValidationMessage(String expectedMessage) {
        String errorMsg = getElementText(LOGIN_VALIDATION_ERROR);
        Assert.assertTrue(errorMsg.contains(expectedMessage));
    }

    public void clearInvalidTolken() {
        if (isElementPresent(INVALID_TOLKEN_LOC)) {
            getElement(INVALID_TOLKEN_LOC).click();
        }
    }
}

