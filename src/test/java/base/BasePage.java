package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {

    //VARIABLE DECLARATION
    public WebDriver driver;
    public WebDriverWait wait;

    //CONSTRUCTOR
    public BasePage() {
        driver = DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void openUrl(String url) {
        driver.get(url);
    }




}
