package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * The class represents the Admin Dashboard page
 */
public class AdminDashBoardPage extends ParentPage {
    public final static By LOGOUT_BUTTON = By.xpath("//i[contains(@class,'fa-sign-out')]/following-sibling::span");

    public AdminDashBoardPage(WebDriver driver) {
        super(driver);
    }

    /**
     * This method checks whether the LogOut button is displayed
     * @return returns boolean
     */

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(LOGOUT_BUTTON);
    }

    /**
     * This method logs out of Admin Dashboard page
     */

    public void logout() {
        click(LOGOUT_BUTTON);
    }
}
