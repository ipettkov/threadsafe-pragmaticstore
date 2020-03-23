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

    /**
     *  Method which locates and clicks a certain menu, passed as a parameter, from the Footer page.
     * @param menu - accepts String with the following valid options: contacts (for the Contact Us page), gifts (for the Gift Certificates page)
     */

    public void clickOption(String menu) {
        switch(menu) {
            case "contacts":
                click(CONTACTS);
                break;
            case "gifts":
                click(GIFTS_CERTIFICATES);
                break;
            default:
                throw new RuntimeException("Non-existing menu: " + menu);
        }
    }
}
