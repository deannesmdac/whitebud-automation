package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.RegistrationPage;

import java.util.Locale;

public class RegistrationStep {

    // Page object instance
    private final RegistrationPage registrationPage =
            Hooks.getPageManager().getRegistrationPage();

    // Logger for execution logs
    private static final Logger logger =
            LoggerFactory.getLogger(RegistrationStep.class);

    /**
     * Navigates user to SMAC Registration Portal.
     */
    @Given("Member navigates to the SMAC Web Registration Portal")
    public void memberNavigatesToTheSMACWebRegistrationPortal() {

        logger.info("⚙️ Navigating to SMAC Registration Portal");

        // Open registration portal URL
        registrationPage.openUrl(
                "https://awsuat-outsys.smadvantage.com/smaconlineacquisition/"
        );

        logger.info("✅ Navigation completed");
    }

    /**
     * Verifies whether the registration portal is displayed.
     *
     * @param portalName expected portal name
     */
    @Then("the {string} portal is displayed")
    public void thePortalIsDisplayed(String portalName) {

        logger.info(
                "⚙️ Verifying portal display: {}",
                portalName
        );

        // Validate registration page visibility
        Assert.assertTrue(
                registrationPage.isRegistrationPageDisplayed(),
                "SMAC Registration portal is not displayed"
        );

        logger.info(
                "✅ Portal displayed successfully: {}",
                portalName
        );
    }

    /**
     * Leaves specified field blank.
     * Triggers inline validation error.
     */
    @When("the member leaves the first name field blank")
    public void theMemberLeavesTheFirstNameFieldBlank() {

        logger.info("⚙️ Leaving the first name field blank");
        registrationPage.leaveFirstNameFieldBlank();
        logger.info("✅ First name field left blank successfully");
    }

    /**
     * Verifies inline validation error message.
     *
     * @param errorMessage expected validation message
     */
    @Then("the inline error message {string} should be displayed")
    public void theInlineErrorMessageShouldBeDisplayed(String errorMessage) {

        logger.info("⚙️ Validating error message");

        Assert.assertTrue(
                registrationPage.isFirstNameRequiredErrorDisplayed(),
                "Expected error message is not displayed"
        );

        String actualMessage =
                registrationPage.getFNameFieldRequiredErrorTxt();

        logger.info("🔎 Expected Message: {}", errorMessage);
        logger.info("🔎 Actual Message: {}", actualMessage);

        Assert.assertEquals(
                actualMessage,
                errorMessage,
                "Inline error message mismatch"
        );

        logger.info("✅ Error message validation passed");
    }

    @When("the member enters valid registration details")
    public void theMemberEntersTheMemberEntersValidRegistrationDetails() {

        logger.info("⚙️ Entering valid registration details");
        registrationPage.enterValidRegistrationDetails();
        logger.info("✅ Entering valid registration detail done");

    }

    @And("the member enters {string} in the First Name field")
    public void theMemberEntersInTheFirstNameField(String value) {

        logger.info("⚙️ Clearing the first name field");
        registrationPage.clearFirstNameField();
        logger.info("✅ First Name field is cleared successfully");

        logger.info("⚙️ Entering value in the First Name field");
        registrationPage.enterFirstNameField(value);
        logger.info("✅ Value entered in the First Name field successfully");
    }

    @And("the member ticks the SMAC Terms and Conditions and Data Privacy Policy")
    public void theMemberTicksTheSMACTermsAndConditionsAndDataPrivacyPolicy() {

        logger.info("⚙️ Consent checkbox is visible");
        registrationPage.clickConsentCheckbox();
        logger.info("✅ Consent checkbox is ticked");

    }

    @And("the member clicks the Proceed button")
    public void memberClicksTheProceedButton() {

        logger.info("⚙️ Proceed button is clickable");
        registrationPage.clickProceedButtonDP();
        logger.info("✅ Proceed button is clicked");
    }

    @Then("the Link Card Page should be displayed")
    public void theLinkCardTabShouldBeDisplayed() {

        logger.info("⚙️ Waiting for Link Card Page visibility");
        registrationPage.linkCarPageDisplayed();
        logger.info("✅ Link Card Page is displayed successfully");
    }


    @Then("the inline error message {string} is displayed")
    public void theInlineErrorMessageIsDisplayed(String errorMessage) {
        logger.info("⚙️ Validating error message");

        Assert.assertTrue(
                registrationPage.isEnterValidFNameErrorDisplayed(),
                "Expected error message is not displayed"
        );

        String actualMessage =
                registrationPage.getEnterValidFNameErrorTxt();

        logger.info("🔎 Expected Message: {}", errorMessage);
        logger.info("🔎 Actual Message: {}", actualMessage);

        Assert.assertEquals(
                actualMessage,
                errorMessage,
                "Inline error message mismatch"
        );

        logger.info("✅ Error message validation passed");
    }


}
