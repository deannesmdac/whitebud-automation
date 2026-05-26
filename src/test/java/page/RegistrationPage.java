package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegistrationPage extends BasePage {

    // CONSTRUCTOR
    public RegistrationPage() {
        super();
    }

    // LOCATORS
    private By smacRegistrationTitleText = By.xpath("//span[@class=\"margin-right-s\" and text()=\"Mobile Number\"]");
    private By detailsTab = By.id("b5-b1-Title");

//    public boolean isRegistrationPageVisible() {
//
//        return wait.until(
//                ExpectedConditions.visibilityOfElementLocated(smacRegistrationTitleText)
//        .isDisplayed());
//
//    }

    public boolean smacRegistrationTitleIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(smacRegistrationTitleText)).isDisplayed();
    }

    public boolean detailsTabIsDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(detailsTab)).isDisplayed();
    }

}