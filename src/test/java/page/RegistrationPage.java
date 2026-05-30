package page;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage extends BasePage {

    /**
     * Constructor
     * Initializes RegistrationPage with active WebDriver.
     *
     * @param driver active browser driver
     */
    public RegistrationPage(WebDriver driver) {

        this.driver = driver;
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

    private final By proceedButton =
            By.xpath("//button[text()='Proceed' and @disabled]");

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

    private final By firstNameRequiredError =
            By.xpath("//span[text()='This field is required.']");

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
                proceedButton,
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

    // =========================
    // ACTIONS
    // =========================

    /**
     * Leaves First Name field blank
     * by clicking field then pressing TAB.
     * Triggers validation message.
     */
    public void leaveFirstNameFieldBlank() {

        clickAndTab(firstNameField);
    }

    // =========================
    // VALIDATIONS
    // =========================

    /**
     * Retrieves First Name required error text.
     *
     * @return validation message text
     */
    public String getFNameFieldRequiredErrorTxt() {

        return getText(firstNameRequiredError);
    }

    /**
     * Verifies whether First Name required
     * error message is displayed.
     *
     * @return true if error message is visible
     */
    public boolean isFirstNameRequiredErrorDisplayed() {

        return isDisplayed(firstNameRequiredError);
    }
}