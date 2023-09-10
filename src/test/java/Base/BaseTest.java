package Base;


import Enums.BrowserType;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BaseTest {
    private static WebDriver webDriver;
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);

    @Rule
    public TestWatcher watcher = BaseRules.createScreenshotRule(this);

    @Before
    public void setUp() {
        String browser = System.getProperty("BROWSER");
        //browser = "CHROME";
        BrowserType browserType = BrowserType.valueOf(browser.toUpperCase());
        logger.info("---Test is starting---");
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                //chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
                chromeOptions.addArguments("disable-translate");
                chromeOptions.addArguments("disable-notifications");
                chromeOptions.addArguments("--headless");
                chromeOptions.setBrowserVersion("116");
                setWebDriver(new ChromeDriver(chromeOptions));
                break;
            case EDGE:
                EdgeOptions edgeOptions = new EdgeOptions();
                setWebDriver(new EdgeDriver(edgeOptions));
                break;
            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                //options.setBrowserVersion("116");
                setWebDriver(new FirefoxDriver(firefoxOptions));
                break;
            case SAFARI:
                SafariOptions safariOptions = new SafariOptions();
                //options.setBrowserVersion("16.1");
                setWebDriver(new SafariDriver(safariOptions));
                break;
        }
        logger.info(browser + " driver is running");
        webDriver.manage().window().maximize();
        //webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(35));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @AfterClass
    public static void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
            logger.info("---Test finished---");
        }
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public void setWebDriver(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}
