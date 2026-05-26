package hooks;

import base.DriverManager;
import base.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {

    private static PageManager pageManager;
    private static WebDriver driver;

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

        System.out.println("Browser opened");
    }

    @After
    public void tearDown() {

        if (driver != null) {

            DriverManager.quitDriver();

            System.out.println("Browser closed");

            pageManager = null;
        }
    }
}