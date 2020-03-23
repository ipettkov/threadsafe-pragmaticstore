package bg.pragmatic.tests.user.positive;

import bg.pragmatic.core.core.App;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BrokenLinksTest {
    App app;

    @BeforeClass
    public void setUp() {
        app = new App();
        app.startBrowser(App.USER_PAGE);
    }

    @AfterClass
    public void killBrowser() {
        app.quit();
    }

    @Test
    public void brokenLinksTest() {
        app.homePage.brokenLinksTest();
    }
}
