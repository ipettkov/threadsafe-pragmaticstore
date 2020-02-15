package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrdersPage extends ParentPage {
    public final static By ORDER_STATUS = By.id("input-order-status");

    public OrdersPage(WebDriver driver) {
        super(driver);
    }
}
