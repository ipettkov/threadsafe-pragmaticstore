package bg.pragmatic.tests.admin.positive;

import bg.pragmatic.core.core.App;
import bg.pragmatic.core.pages.OrdersPage;
import enums.Password;
import enums.Username;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OrderStatusContentTest {
    private App app;
    private final static String[] EXPECTED_ORDERS_MENU_CONTENT = {"",
            "Missing Orders", "Canceled", "Canceled Reversal", "Chargeback", "Complete", "Denied", "Expired",
            "Failed", "Pending", "Processed", "Processing", "Refunded", "Reversed", "Shipped", "Voided"};

    @BeforeMethod
    public void setUp() {
        app = new App();
        app.startBrowser(App.ADMIN_PAGE);
    }

    @AfterMethod
    public void quit() {
        app.quit();
    }

    @Test
    public void orderStatusContentTest() {
        app.adminLoginPage.login(Username.VALID_USERNAME, Password.ADMIN_PASSWORD);
        app.navigationPage.clickMenu("sales");
        app.navigationPage.clickMenu("orders");
        app.ordersPage.verifyDropDownMenuContent(OrdersPage.ORDER_STATUS, EXPECTED_ORDERS_MENU_CONTENT);
    }
}
