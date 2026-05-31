package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.PendingException;
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
                "https://awsstgexternal-outsys.smadvantage.com/SMACOnlineAcquisition/"
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

    @When("the member leaves the {string} field blank")
    public void theMemberLeavesTheBlank(String fieldName) {

        registrationPage.leaveFieldBlank(fieldName);
    }

    @Then("the inline error message for missing {string} is {string}")
    public void theInlineErrorMessageShouldBeDisplayed(
            String fieldName,
            String errorMessage) {

        logger.info("⚙️ Validating error message for field: {}", fieldName);

        Assert.assertTrue(
                registrationPage.isFieldErrorDisplayed(fieldName),
                "Error message is not displayed for field: " + fieldName
        );

        String actualMessage =
                registrationPage.getFieldErrorMessage(fieldName);

        logger.info("🔎 Expected Message: {}", errorMessage);
        logger.info("🔎 Actual Message: {}", actualMessage);

        Assert.assertEquals(
                actualMessage,
                errorMessage,
                "Error message mismatch for field: " + fieldName
        );

        logger.info("✅ Error message validation passed for field: {}", fieldName);
    }


    /**
     * Leaves specified field blank.
     * Triggers inline validation error.
     *
     * @param fieldName field to leave blank
     */
//    @When("the member leaves the {string} field blank")
//    public void theMemberLeavesTheFieldBlank(String fieldName) {
//
//        logger.info(
//                "⚙️ Leaving '{}' field blank",
//                fieldName
//        );
//
//        // Leave first name field blank
//        registrationPage.leaveFirstNameFieldBlank();
//
//        logger.info(
//                "✅ Field '{}' left blank successfully",
//                fieldName
//        );
//    }
//
//    /**
//     * Verifies inline validation error message.
//     *
//     * @param expectedMessage expected validation message
//     */
//    @Then("the inline error message {string} should be displayed")
//    public void theInlineErrorMessageShouldBeDisplayed(String expectedMessage) {
//
//        logger.info("⚙️ Validating inline error message");
//
//        // Verify error message is displayed
//        Assert.assertTrue(
//                registrationPage.isFirstNameRequiredErrorDisplayed(),
//                "Expected error message is not displayed"
//        );
//
//        // Retrieve actual validation message
//        String actualMessage =
//                registrationPage.getFNameFieldRequiredErrorTxt();
//
//        logger.info(
//                "🔎 Expected message: {}",
//                expectedMessage
//        );
//
//        logger.info(
//                "🔎 Actual message: {}",
//                actualMessage
//        );
//
//        // Validate message text
//        Assert.assertEquals(
//                actualMessage,
//                expectedMessage,
//                "Inline error message mismatch"
//        );
//
//        logger.info(
//                "✅ Inline error message validation passed"
//        );
//    }

//    @When("the member enters numeric characters in the First Name field")
//    public void theMemberEntersNumericCharactersInTheFirstNameField() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @Then("the inline error message {string} is displayed")
//    public void theInlineErrorMessageIsDisplayed(String arg0) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
}
