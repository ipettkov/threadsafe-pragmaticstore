package bg.pragmatic.tests.admin.negative;

import bg.pragmatic.core.core.App;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AdminLoginDataDrivenTest {
    private App app;

    @BeforeTest
    public void setUp() {
        app = new App();
        app.startBrowser(App.ADMIN_PAGE);
    }

    @AfterTest
    public void killBrowser() {
        app.quit();
    }

    @DataProvider
    public Object[][] testData() {
        return app.adminLoginPage.getTestData();
    }

    @Test(dataProvider = "testData")
    public void negativeLogin(String username, String password, String errorVerification) {
        app.adminLoginPage.clearInvalidTolken();
        app.adminLoginPage.clearLoginFields();
        app.adminLoginPage.loginDDT(username, password);
        app.adminLoginPage.verifyErrorValidationMessage(errorVerification);
    }
}
