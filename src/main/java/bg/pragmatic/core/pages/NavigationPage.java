package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationPage extends ParentPage {
    private static final By SALES_MENU = By.id("menu-sale");
    private static final By ORDERS_MENU = By.cssSelector("ul#collapse26 a[href*='route=sale/order']");
    private static final By RETURNS_MENU = By.cssSelector("a[href*='route=sale/return']");

    public NavigationPage(WebDriver driver) {
        super(driver);
    }

    public void clickMenu(String chooseMenu) {
        switch (chooseMenu) {
            case "sales":
                waitForElement(SALES_MENU);
                click(SALES_MENU);
                break;
            case "orders":
                waitForElement(ORDERS_MENU);
                click(ORDERS_MENU);
                break;
            case "returns":
                waitForElement(RETURNS_MENU);
                click(RETURNS_MENU);
                break;
            default:
                throw new RuntimeException("The chosen menu " + chooseMenu + " does not exist");
        }
    }
}
