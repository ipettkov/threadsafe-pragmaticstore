package bg.pragmatic.core.pages;

import bg.pragmatic.core.pages.base.ParentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FooterPage extends ParentPage {
    private final static By CONTACTS = By.cssSelector("ul.list-unstyled a[href*='information/contact']");
    private final static By GIFTS_CERTIFICATES = By.xpath("//a[text()='Gift Certificates']");

    public FooterPage(WebDriver driver) {
        super(driver);
    }

    public void clickOption(String menu) {
        switch(menu) {
            case "contacts":
                getElement(CONTACTS).click();
                break;
            case "gifts":
                getElement(GIFTS_CERTIFICATES).click();
                break;
            default:
                throw new RuntimeException("Non-existing menu: " + menu);
        }
    }
}
