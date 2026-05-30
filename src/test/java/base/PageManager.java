package base;

import org.openqa.selenium.WebDriver;
import page.RegistrationPage;

public class PageManager {

    // WebDriver instance used by page objects
    private WebDriver driver;

    // Page object declaration
    private RegistrationPage registrationPage;

    /**
     * Constructor
     * Initializes PageManager with active WebDriver.
     *
     * @param driver active browser driver
     */
    public PageManager(WebDriver driver) {

        this.driver = driver;
    }

    /**
     * Returns RegistrationPage object.
     * Creates the page object only once (Lazy Initialization).
     *
     * @return RegistrationPage instance
     */
    public RegistrationPage getRegistrationPage() {

        // Create page object only if it does not exist
        if (registrationPage == null) {

            registrationPage = new RegistrationPage(driver);
        }

        return registrationPage;
    }
}