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

    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    public static PageManager getPageManager() {
        return pageManager;
    }

    @Before
    public void setUp() {

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();

        if (driver == null) {
            throw new RuntimeException("Driver was not initialized properly");
        }

        pageManager = new PageManager(driver);

        logger.info("Browser opened");
    }

    @After
    public void tearDown(Scenario scenario) {

        //FOR FAILED AND PASSED END-STATE SCREENSHOTS
        try {

            if (driver != null) {

                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.isFailed()
                                ? "Failure Screenshot"
                                : "End State Screenshot"
                );
            }

        } catch (Exception e) {

            logger.error("Failed to capture screenshot", e);

        }

        try {

            DriverManager.quitDriver();
            logger.info("Browser closed");

        } catch (Exception e) {

            logger.error("Failed to close browser", e);

        }

        driver = null;
        pageManager = null;

    }
        //FAILED SCREENSHOTS ONLY
//        try {
//            if (scenario.isFailed() && driver != null) {
//                byte[] screenshot = ((TakesScreenshot) driver)
//                        .getScreenshotAs(OutputType.BYTES);
//
//                scenario.attach(screenshot, "image/png", "Failure Screenshot");
//            }
//        } catch (Exception e) {
//            logger.error("Failed to capture screenshot", e);
//        }
//
//        try {
//            DriverManager.quitDriver();
//            logger.info("Browser closed");
//        } catch (Exception e) {
//            logger.error("Error while quitting driver", e);
//        }
//
//        driver = null;
//        pageManager = null;
//    }
}