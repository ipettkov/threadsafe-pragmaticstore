package bg.pragmatic.tests.user.negative;

import bg.pragmatic.core.core.App;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GiftsCertificateTest {
    private App app;

    @BeforeMethod
    public void setUp() {
        app = new App();
        app.startBrowser(App.USER_PAGE);
    }

    @AfterMethod
    public void quit() {
        app.quit();
    }

    @Test
    public void emptyFieldErrorValidationTest() {
        app.footerPage.clickOption("gifts");
        app.giftsCertificatePage.verifyEmptyFieldsError("name", "ivan");
    }
}
