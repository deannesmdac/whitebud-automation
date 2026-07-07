package base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.LocatorReader;

import java.time.Duration;

public class BasePage {

    // Shared WebDriver instance
    protected WebDriver driver;

    // Explicit wait object
    protected WebDriverWait wait;

    /**
     * Constructor
     * Initializes driver and wait.
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    /**
     * Opens the specified URL.
     *
     * @param url website URL
     */
    public void openUrl(String url) {

        driver.get(url);
    }

    /**
     * Clicks an element after waiting for it to become clickable.
     *
     * @param locator element locator
     */
    public void click(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        element.click();
    }

    /**
     * Clicks an element then presses TAB key.
     * Commonly used for triggering field validation.
     *
     * @param locator element locator
     */
    public void clickAndTab(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );

        element.click();
        element.sendKeys(Keys.TAB);
    }

    public void tab(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(locator)
        );
        element.sendKeys(Keys.TAB);
    }

    /**
     * Retrieves visible text from an element.
     *
     * @param locator element locator
     * @return element text
     */
    public String getText(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).getText();
    }

    /**
     * Verifies whether an element is displayed.
     *
     * @param locator element locator
     * @return true if displayed
     */
    public boolean isDisplayed(By locator) {

        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        ).isDisplayed();
    }

    /**
     * Inputs text into a field.
     * Waits until the element is visible before typing.
     *
     * @param locator element locator
     * @param text value to input
     */
    public void type(By locator, String text) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        // Clears existing text before typing
        element.clear();

        // Inputs new text
        element.sendKeys(text);
    }

    public void scrollTo(By locator) {

        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript(
                "arguments[0].scrollIntoView({block: 'center'});",
                element
        );
    }

    public void clearField(By locator) {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
        element.clear();
    }

    public String getElementText(By locator){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator))
                .getText();
    }

    public boolean isElementEnabled(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.isEnabled();
    }

    public String isDisabled(By locator){
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
       return  element.getAttribute("disabled");
    }


    public void clickLocator(String locatorName) {
        click(LocatorReader.getLocator(locatorName));
    }

    public void enterText(String locatorName, String text) {
        type(LocatorReader.getLocator(locatorName), text);
    }

    public void scrollToLocator(String locatorName) {
        scrollTo(LocatorReader.getLocator(locatorName));
    }

}