package bg.pragmatic.tests.admin.positive;

import bg.pragmatic.core.core.App;
import enums.Password;
import enums.Username;
import static org.testng.Assert.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AdminLoginTest {

    private App app;

    @BeforeMethod
    public void setUp() {
        app = new App();
        app.startBrowser(App.ADMIN_PAGE);
    }

    @AfterMethod
    public void killBrowser() {
        app.quit();
    }

    @Test
    public void successfulLoginTest() {
        app.adminLoginPage.login(Username.VALID_USERNAME, Password.ADMIN_PASSWORD);
        app.adminDashBoardPage.validateSuccessfulLogin();
    }
}
