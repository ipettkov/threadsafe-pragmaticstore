package bg.pragmatic.core.core;

import bg.pragmatic.core.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;

/**
 * The main operational class of the page object model pattern used in this framework which instantiates all pages through the startBrowser method allowing
 * to work with their fields and methods for the tests
 */

public class App {
    public HomePage homePage;
    private WebDriver driver;
    public final static  String ADMIN_PAGE = "http://shop.pragmatic.bg/admin";
    public final static String USER_PAGE = "http://shop.pragmatic.bg/";
    public AdminLoginPage adminLoginPage;
    public AdminDashBoardPage adminDashBoardPage;
    public NavigationPage navigationPage;
    public OrdersPage ordersPage;
    public FooterPage footerPage;
    public GiftsCertificatePage giftsCertificatePage;
    public ReturnsPage returnsPage;

    /**
     * The Method starts a browser by settings it's properties and instantiates a WebDriver and all the pages that you can use for tests
     * @param pageToOpen - accepts String with the page you want to be in
     */

    public void startBrowser(String pageToOpen) {
        String driverPath = Paths.get("chromedriver.exe").toAbsolutePath().toString();
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        adminLoginPage = new AdminLoginPage(driver);
        adminDashBoardPage = new AdminDashBoardPage(driver);
        navigationPage = new NavigationPage(driver);
        ordersPage = new OrdersPage(driver);
        footerPage = new FooterPage(driver);
        giftsCertificatePage = new GiftsCertificatePage(driver);
        returnsPage = new ReturnsPage(driver);
        homePage = new HomePage(driver);

        driver.get(pageToOpen);
    }

    public void quit() {
        driver.quit();
    }
}


