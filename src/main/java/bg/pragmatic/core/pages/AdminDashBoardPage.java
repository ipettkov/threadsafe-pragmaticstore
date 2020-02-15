package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminDashBoardPage extends ParentPage {
    public final static By LOGOUT_BUTTON = By.xpath("//i[contains(@class,'fa-sign-out')]/following-sibling::span");

    public AdminDashBoardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isLogoutButtonDisplayed() {
        return isDisplayed(LOGOUT_BUTTON);
    }

    public void logout() {
        click(LOGOUT_BUTTON);
    }
}
