package page;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class RegistrationPage extends BasePage {

    /**
     * Constructor
     * Initializes RegistrationPage with active WebDriver.
     *
     * @param driver active browser driver
     */
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    // =========================
    // TAB LOCATORS
    // =========================

    private final By detailsTab =
            By.id("b5-b1-Title");

    private final By linkCardTab =
            By.id("b5-b3-Title");

    private final By verificationTab =
            By.id("b5-b5-Title");

    // =========================
    // TEXT LOCATORS
    // =========================

    private final By registrationTitle =
            By.xpath("//span[@class='margin-right-s' and text()='Mobile Number']");

    private final By nameLabel =
            By.xpath("//*[@id='b6-b1-b2-Column1']/div/label/span");

    private final By mobileNumberLabel =
            By.xpath("//label[@for='b6-b1-Input_MobNum']");

    private final By emailAddressLabel =
            By.xpath("//label[@for='b6-b1-Input_EmailAddress']");

    private final By birthdayLabel =
            By.xpath("//label[@for='b6-b1-Input_Birthday']");

    private final By passwordLabel =
            By.xpath("//label[@for='b6-b1-Input_Password']");

    private final By confirmPasswordLabel =
            By.xpath("//label[@for='b6-b1-Input_PasswordConfirmation']");

    private final By emailOptionalText =
            By.xpath("//span[text()='(optional)']");

    // =========================
    // FIELD LOCATORS
    // =========================

    // Details Page
    private final By firstNameField =
            By.id("b6-b1-Input_FirstName");

    private final By lastNameField =
            By.id("b6-b1-Input_LastName");

    private final By mobileNumberField =
            By.id("b6-b1-Input_MobNum");

    private final By emailField =
            By.id("b6-b1-Input_EmailAddress");

    private final By birthdayField =
            By.id("b6-b1-Input_Birthday");

    private final By passwordField =
            By.id("b6-b1-Input_Password");

    private final By confirmPasswordField =
            By.id("b6-b1-Input_PasswordConfirmation");

    //Link Card Page
    private final By enterSMACNumberField = By.id("b6-b2-Input_CardNumber");


    // =========================
    // CHECKBOX LOCATORS
    // =========================

    private final By updatesCheckbox =
            By.id("b6-b1-Checkbox_UpdatesConsent");

    private final By consentCheckbox =
            By.id("b6-b1-Checkbox_SMACConsent");

    // =========================
    // BUTTON LOCATORS
    // =========================

    //Details Page
    private final By proceedButtonDP =
            By.xpath("//*[@class='btn btn-primary full-width' and text() = 'Proceed']");
    //Link Card Page
    private final By backButtonLCP = By.id("b3-Icon");
    private final By homeButtonLCP = By.id("b4-Icon");

    // =========================
    // LINK LOCATORS
    // =========================

    private final By termsAndConditionsLink =
            By.xpath("//span[text()='Terms and Conditions']");

    private final By privacyPolicyLink =
            By.xpath("//span[text()='Privacy Policy']");

    // =========================
    // ERROR LOCATORS
    // =========================

    private final By fieldIsRequiredError = By.xpath("//*[text()='This field is required.']");
    private final By enterValidFNameError = By.xpath("//*[text()='Enter a valid first name.']");
    private final By enterValidLNameError = By.xpath("//*[text()='Enter a valid last name.']");
    private final By birthdayRequiredError = By.xpath("//*[@id=\"b6-b1-b5-Input\"]/span/span");
    private final By mobileNumberRequiredError = By.xpath("//span[text()=\"Please enter a complete mobile number.\"]");
    private final By passwordRequiredError = By.xpath("//span[text()=\"Password not strong enough.\"]");

    // =========================
    // PAGE VALIDATION
    // =========================

    /**
     * Verifies whether the Registration Page is displayed.
     *
     * @return true if all important elements are visible
     */
    public boolean isRegistrationPageDisplayed() {

        By[] pageElements = {

                registrationTitle,
                detailsTab,
                linkCardTab,
                verificationTab,
                nameLabel,
                mobileNumberLabel,
                emailAddressLabel,
                birthdayLabel,
                passwordLabel,
                confirmPasswordLabel,
                emailOptionalText,
                firstNameField,
                lastNameField,
                mobileNumberField,
                emailField,
                birthdayField,
                passwordField,
                confirmPasswordField,
                updatesCheckbox,
                consentCheckbox,
                proceedButtonDP,
                termsAndConditionsLink,
                privacyPolicyLink
        };

        // Verify all elements are displayed
        for (By element : pageElements) {

            if (!isDisplayed(element)) {

                return false;
            }
        }

        return true;
    }

    public boolean linkCarPageDisplayed() {
        By[] pageElements = {
                enterSMACNumberField,
                backButtonLCP,
                homeButtonLCP
        };
        for (By element : pageElements) {

            if (!isDisplayed(element)) {

                return false;
            }
        }

        return true;
    }

    // =========================
    // ACTIONS
    // =========================

    public void enterFirstNameField(String firstName) {
        click(firstNameField);
        type(firstNameField, firstName);
    }

    public void enterLastNameField(String lastName) {
        click(lastNameField);
        type(lastNameField, lastName);
    }

    public void enterMobileNumberField(String mobileNumber) {
        click(mobileNumberField);
        type(mobileNumberField, mobileNumber);
    }

    public void enterBirthdayField(String birthday) {
        click(birthdayField);
        type(birthdayField, birthday);
    }

    public void enterPasswordField(String password) {
        click(passwordField);
        type(passwordField, password);
        tab(passwordField);
    }

    public void enterConfirmPasswordField(String password) {

        type(confirmPasswordField, password);
    }

    public void clickConsentCheckbox() {
//        scrollTo(proceedButtonDP);
//        click(consentCheckbox);

        WebElement checkbox = wait.until(
                ExpectedConditions.elementToBeClickable(consentCheckbox));

        ((JavascriptExecutor) driver)
                .executeScript(
                        "arguments[0].scrollIntoView({block:'center'});",
                        checkbox);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", checkbox);
    }

    public void clickProceedButtonDP() {
        driver.findElement(consentCheckbox).sendKeys(Keys.TAB);
        scrollTo(proceedButtonDP);
        click(proceedButtonDP);
    }

    // =========================
    // GETTER METHODS
    // =========================

    /**
     * Retrieves First Name required error text.
     *
     * @return validation message text
     */
    public String getFNameFieldRequiredErrorTxt() {

        return getText(fieldIsRequiredError);
    }

    public String getLNameFieldRequiredErrorTxt() {

        return getText(fieldIsRequiredError);
    }

    public String getEnterValidFNameErrorTxt() {

        return getText(enterValidFNameError);
    }

    public String getEnterValidLNameErrorTxt() {

        return getText(enterValidLNameError);
    }


    // =========================
    // VALIDATIONS
    // =========================

    /**
     * Verifies whether First Name required
     * error message is displayed.
     *
     * @return true if error message is visible
     */
    public boolean isFirstNameRequiredErrorDisplayed() {

        return isDisplayed(fieldIsRequiredError);
    }

    public boolean isLastNameRequiredErrorDisplayed() {

        return isDisplayed(fieldIsRequiredError);
    }

    public boolean isEnterValidFNameErrorDisplayed(){
        return isDisplayed(enterValidFNameError);
    }

    public boolean isEnterValidLNameErrorDisplayed(){
        return isDisplayed(enterValidLNameError);
    }
}