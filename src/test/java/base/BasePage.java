package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    //Opens website
    public void openUrl(String url) {
        driver.get(url);
    }

    //Clicks element then moves to the next field
    public void clickAndTab(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        element.click();
        element.sendKeys(Keys.TAB);
    }

    //Retrieves the visible text from a web element
    public String getText(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).getText();
    }

    //Verifies if the element is displayed
    public boolean isDisplayed(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator).isDisplayed();
    }





}
