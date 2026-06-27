package hooks;

import base.DriverManager;
import base.PageManager;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import report.ExtentManager;
import report.ExtentTestManager;

public class Hooks {

    // Shared PageManager instance
    private static PageManager pageManager;

    // Shared WebDriver instance
    private static WebDriver driver;

    // Logger
    private static final Logger logger =
            LoggerFactory.getLogger(Hooks.class);

    /**
     * Returns PageManager instance.
     */
    public static PageManager getPageManager() {
        return pageManager;
    }

    /**
     * Runs before every scenario.
     */
    @Before
    public void setUp(Scenario scenario) {

        logger.info("========================================");
        logger.info("Starting Scenario: {}", scenario.getName());
        logger.info("========================================");

        DriverManager.initializeDriver();

        driver = DriverManager.getDriver();

        if (driver == null) {
            throw new RuntimeException("Driver was not initialized.");
        }

        pageManager = new PageManager(driver);

        ExtentTest test = ExtentManager.getInstance()
                .createTest(scenario.getName());

        ExtentTestManager.setTest(test);

        logger.info("Browser opened successfully.");
    }

    /**
     * Runs after every scenario.
     */
    @After
    public void tearDown(Scenario scenario) {

        try {

            if (driver != null) {

                String base64 = ((TakesScreenshot) driver)
                        .getScreenshotAs(OutputType.BASE64);

                if (scenario.isFailed()) {

                    ExtentTestManager.getTest()
                            .fail("Scenario Failed")
                            .addScreenCaptureFromBase64String(
                                    base64,
                                    "Failure Screenshot");

                    logger.error("Scenario FAILED: {}", scenario.getName());

                } else {

                    ExtentTestManager.getTest()
                            .pass("Scenario Passed")
                            .addScreenCaptureFromBase64String(
                                    base64,
                                    "End State Screenshot");

                    logger.info("Scenario PASSED: {}", scenario.getName());
                }
            }

        } catch (Exception e) {

            logger.error("Failed to capture screenshot.", e);

        } finally {

            DriverManager.quitDriver();

            logger.info("Browser closed.");

            driver = null;
            pageManager = null;

            ExtentTestManager.unload();
        }
    }

    /**
     * Runs once after all scenarios.
     */
    @AfterAll
    public static void generateReport() {

        ExtentManager.flush();

        logger.info("========================================");
        logger.info("Extent Report generated successfully.");
        logger.info("Location: {}", ExtentManager.getReportPath());
        logger.info("========================================");
    }
}