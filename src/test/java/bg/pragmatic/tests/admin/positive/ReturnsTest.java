package bg.pragmatic.tests.admin.positive;

import bg.pragmatic.core.core.App;
import bg.pragmatic.core.pages.ReturnsPage;
import enums.Password;
import enums.Username;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ReturnsTest {
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
    public void returnsDropDownTest() {
        app.adminLoginPage.login(Username.VALID_USERNAME, Password.ADMIN_PASSWORD);
        app.navigationPage.clickMenu("sales");
        app.navigationPage.clickMenu("returns");
        app.returnsPage.verifyOptionsNumber(ReturnsPage.RETURNS_DROPDOWN,4,"Actual and expected menu options' number mismatch");
    }

}
