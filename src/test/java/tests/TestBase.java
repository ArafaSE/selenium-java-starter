package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public  String HOME_URL = "https://www.saucedemo.com";
    @BeforeClass
    @Parameters({"browser"})
    public void startDriver(@Optional("chrome") String browserName) {
        if (browserName.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.addArguments("--start-maximized");

            driver = new ChromeDriver(chromeOptions);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
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
        driver.navigate().to(HOME_URL);
    }

    @AfterClass
    public void stopDriver() {
        driver.close();
        driver.quit();
    }
}
