package hooks;

import Base.DriverManager;
import Base.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class Hooks {
    private static PageManager pageManager;
    private static WebDriver driver;
    public static PageManager getPageManager(){
        return pageManager;
    }

    @Before
    public void setUp() {

        pageManager = new PageManager(driver);
        DriverManager.getDriver();
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