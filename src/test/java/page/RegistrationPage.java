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
    private By linkCardTab = By.id("b5-b3-Title");
    private By verificationTab = By.id("b5-b5-Title");
    private By nameTxt = By.xpath("//*[@id=\"b6-b1-b2-Column1\"]/div/label/span");


    private By mobileNumberTxt = By.xpath("//label[@for=\"b6-b1-Input_MobNum\"]");
    private By emailAddressTxt = By.xpath("//label[@for=\"b6-b1-Input_EmailAddress\"]");
    private By birthdayTxt = By.xpath("//label[@for=\"b6-b1-Input_Birthday\"]");
    private By passwordTxt = By.xpath("//label[@for=\"b6-b1-Input_Password\"]");
    private By passwordConfirmationTxt = By.xpath("//label[@for=\"b6-b1-Input_PasswordConfirmation\"]");
    private By emailOptionalTxt = By.xpath("//span[text()=\"(optional)\"]");
    private By firstNameField = By.id("b6-b1-Input_FirstName");
    private By lastNameField = By.id("b6-b1-Input_LastName");
    private By mobileNumberField = By.id("b6-b1-Input_MobNum");
    private By emailField = By.id("b6-b1-Input_EmailAddress");
    private By birthdayField = By.id("b6-b1-Input_Birthday");
    private By passwordField = By.id("b6-b1-Input_Password");
    private By passwordConfirmationField = By.id("b6-b1-Input_PasswordConfirmation");
    private By updateCheckbox = By.id("b6-b1-Checkbox_UpdatesConsent");
    private By consentCheckbox = By.id("b6-b1-Checkbox_SMACConsent");
    private By proceedBtn = By.xpath("//button[text()=\"Proceed\" and @disabled]");
    private By termsAndConditionsLink = By.xpath("//span[text()=\"Terms and Conditions\"]");
    private By privacyPolicyLink = By.xpath("//span[text()=\"Privacy Policy\"]");




    public boolean isSmacRegistrationPageDisplayed()  {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(smacRegistrationTitleText)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(detailsTab)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(linkCardTab)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(verificationTab)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(nameTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(emailAddressTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(birthdayTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordConfirmationTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(emailOptionalTxt)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(firstNameField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(lastNameField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(mobileNumberField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(birthdayField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(passwordConfirmationField)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(updateCheckbox)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(consentCheckbox)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(proceedBtn)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(termsAndConditionsLink)).isDisplayed() &&
                wait.until(ExpectedConditions.visibilityOfElementLocated(privacyPolicyLink)).isDisplayed();


    }








}