package hooks;

import base.DriverManager;
import base.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {

    private static PageManager pageManager;
    private static WebDriver driver;

    private static Logger logger = LoggerFactory.getLogger(Hooks.class);

    public static PageManager getPageManager() {
        return pageManager;
    }

    @Before
    public void setUp() {

        // Initialize driver first
        DriverManager.initializeDriver();

        // Get initialized driver
        driver = DriverManager.getDriver();

        // Pass driver to PageManager
        pageManager = new PageManager(driver);

        logger.info("Browser opened");
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed() && driver != null) {
            byte[] screenshot = ((TakesScreenshot) driver)
                    .getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png", "Failure Screenshot");
        }

        if (driver != null) {
            driver.quit();
            logger.info("Browser closed");
        }

        pageManager = null;
    }
}
