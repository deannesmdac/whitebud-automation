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

    // Shared PageManager instance
    private static PageManager pageManager;

    // Shared WebDriver instance
    private static WebDriver driver;

    // Logger for framework logs
    private static final Logger logger =
            LoggerFactory.getLogger(Hooks.class);

    /**
     * Returns PageManager instance.
     * Allows access to page objects in step definitions.
     *
     * @return PageManager instance
     */
    public static PageManager getPageManager() {

        return pageManager;
    }

    /**
     * Runs before each scenario.
     * Initializes browser and page objects.
     */
    @Before
    public void setUp() {

        // Initialize browser driver
        DriverManager.initializeDriver();

        // Retrieve active driver instance
        driver = DriverManager.getDriver();

        // Verify driver was initialized successfully
        if (driver == null) {

            throw new RuntimeException(
                    "Driver was not initialized properly"
            );
        }

        // Initialize page manager
        pageManager = new PageManager(driver);

        logger.info("Browser opened");
    }

    /**
     * Runs after each scenario.
     * Captures screenshot and closes browser.
     *
     * @param scenario current executed scenario
     */
    @After
    public void tearDown(Scenario scenario) {

        // =========================
        // SCREENSHOT CAPTURE
        // =========================
        try {

            // Verify driver exists before screenshot
            if (driver != null) {

                // Capture screenshot as byte array
                byte[] screenshot = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BYTES);

                // Attach screenshot to Cucumber report
                scenario.attach(
                        screenshot,
                        "image/png",
                        scenario.isFailed()
                                ? "Failure Screenshot"
                                : "End State Screenshot"
                );
            }

        } catch (Exception e) {

            logger.error(
                    "Failed to capture screenshot",
                    e
            );
        }

        // =========================
        // CLOSE BROWSER
        // =========================
        try {

            // Quit browser session
            DriverManager.quitDriver();

            logger.info("Browser closed");

        } catch (Exception e) {

            logger.error(
                    "Failed to close browser",
                    e
            );
        }

        // =========================
        // CLEANUP
        // =========================

        // Reset objects for next test execution
        driver = null;
        pageManager = null;
    }
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
