package base;

import page.RegistrationPage;
import org.openqa.selenium.WebDriver;

public class PageManager {
    public WebDriver driver;
    public RegistrationPage registrationPage;

    //CONSTRUCTOR
    public PageManager(WebDriver driver) {
        driver = DriverManager.getDriver();
    }

    public RegistrationPage getRegistrationPage() {
        if (registrationPage == null) {
            registrationPage = new RegistrationPage();
        }
        return registrationPage;
    }
}
