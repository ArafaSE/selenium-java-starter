package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.BasePage;
import pages.InventoryPage;
import pages.LoginPage;

public class BaseTest {
    private WebDriver driver;
    protected BasePage basePage;
    protected LoginPage loginPage;
    protected InventoryPage inventoryPage;
    private final String HOME_URL = "https://www.saucedemo.com";
    @BeforeClass
    @Parameters({"browser"})
    public void setUp(@Optional("chrome-headless") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);
            driver.manage().window().maximize();
        }
        // headless browser testing with Chrome headless option
        else if (browserName.equalsIgnoreCase("chrome-headless")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--disable-extensions");
            chromeOptions.addArguments("--ignore-certificate-errors");

            driver = new ChromeDriver(chromeOptions);
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @BeforeMethod
    public void loadApplication(){
        driver.get(HOME_URL);
        basePage = new BasePage();
        basePage.setDriver(driver);
    }
    @AfterMethod
    public void takeScreenshotOnFailures(){
        // todo
    }

    protected String getHomURL(){
        return HOME_URL;
    }

    protected String getCurrentURL(){
        return driver.getCurrentUrl();
    }
}
