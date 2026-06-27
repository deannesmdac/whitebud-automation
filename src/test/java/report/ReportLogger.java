package report;

import com.aventstack.extentreports.Status;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReportLogger {

    private static final Logger logger =
            LoggerFactory.getLogger(ReportLogger.class);

    /**
     * Logs informational messages.
     */
    public static void info(String message) {

        logger.info(message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().info(message);
        }
    }

    /**
     * Logs successful actions.
     */
    public static void pass(String message) {

        logger.info("✅ {}", message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().pass(message);
        }
    }

    /**
     * Logs warnings.
     */
    public static void warning(String message) {

        logger.warn("⚠️ {}", message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().warning(message);
        }
    }

    /**
     * Logs failures.
     */
    public static void fail(String message) {

        logger.error("❌ {}", message);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().fail(message);
        }
    }

    /**
     * Logs exceptions.
     */
    public static void fail(String message, Exception e) {

        logger.error(message, e);

        if (ExtentTestManager.getTest() != null) {
            ExtentTestManager.getTest().log(Status.FAIL, message);
            ExtentTestManager.getTest().fail(e);
        }
    }

    /**
     * Attaches screenshot to Extent Report.
     */
    public static void screenshot(WebDriver driver, String title) {

        if (driver == null || ExtentTestManager.getTest() == null) {
            return;
        }

        try {

            String base64 =
                    ((TakesScreenshot) driver)
                            .getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest()
                    .addScreenCaptureFromBase64String(base64, title);

        } catch (Exception e) {

            logger.error("Unable to capture screenshot.", e);
        }
    }
}