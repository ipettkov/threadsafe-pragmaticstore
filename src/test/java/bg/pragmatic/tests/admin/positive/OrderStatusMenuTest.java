package bg.pragmatic.tests.admin.positive;

import bg.pragmatic.core.core.App;
import bg.pragmatic.core.pages.OrdersPage;
import enums.Password;
import enums.Username;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderStatusMenuTest {

    App app;

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
    public void orderStatusContentNumberTest() {
        app.adminLoginPage.login(Username.VALID_USERNAME, Password.ADMIN_PASSWORD);
        app.navigationPage.clickMenu("sales");
        app.navigationPage.clickMenu("orders");
        app.ordersPage.verifyOptionsNumber(OrdersPage.ORDER_STATUS, 16, "actual and expected menu numbers mismatch");
    }
}
