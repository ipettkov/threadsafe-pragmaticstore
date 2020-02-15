package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReturnsPage extends ParentPage {
    public final static By RETURNS_DROPDOWN = By.cssSelector("select#input-return-status");

    public ReturnsPage(WebDriver driver) {
        super(driver);
    }
}
