package base;

import page.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class PageManager {

    private WebDriver driver;

    private RegistrationPage registrationPage;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage(driver);
        }
        return registrationPage;
    }
}