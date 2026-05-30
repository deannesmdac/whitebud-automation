package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

    // Shared WebDriver instance for the framework
    // static ensures only one browser instance is used
    private static WebDriver driver;

    /**
     * Initializes the WebDriver.
     * Creates a new Chrome browser only if driver is not yet initialized.
     */
    public static void initializeDriver() {

        // Prevent multiple browser instances
        if (driver == null) {

            // Launch Chrome browser
            driver = new ChromeDriver();

            // Maximize browser window
            driver.manage().window().maximize();
        }
    }

    /**
     * Returns the current WebDriver instance.
     *
     * @return active WebDriver
     */
    public static WebDriver getDriver() {

        return driver;
    }

    /**
     * Closes the browser and resets the driver.
     */
    public static void quitDriver() {

        // Check if driver exists before quitting
        if (driver != null) {

            // Close all browser windows and end session
            driver.quit();

            // Reset driver reference
            // Allows fresh browser creation for future tests
            driver = null;
        }
    }
}