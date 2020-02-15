package bg.pragmatic.core.core;

import bg.pragmatic.core.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class App {
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

        driver.get(pageToOpen);
    }

    public void quit() {
        driver.quit();
    }
}


