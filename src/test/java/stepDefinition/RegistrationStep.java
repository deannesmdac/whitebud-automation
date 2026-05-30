package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import hooks.Hooks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import page.RegistrationPage;

public class RegistrationStep {

    private final RegistrationPage registrationPage =
            Hooks.getPageManager().getRegistrationPage();

    private static final Logger logger =
            LoggerFactory.getLogger(RegistrationStep.class);

    @Given("Member navigates to the SMAC Web Registration Portal")
    public void memberNavigatesToTheSMACWebRegistrationPortal() {

        logger.info("⚙️Navigating to SMAC Registration Portal");

        registrationPage.openUrl(
                "https://awsstgexternal-outsys.smadvantage.com/SMACOnlineAcquisition/"
        );

        logger.info("✅Navigation completed");
    }

    @Then("the {string} portal is displayed")
    public void thePortalIsDisplayed(String portalName) {

        logger.info("⚙️Verifying portal display: {}", portalName);

        Assert.assertTrue(
                registrationPage.isSmacRegistrationPageDisplayed(),
                "SMAC Registration portal is not displayed"
        );

        logger.info("✅Portal displayed successfully: {}", portalName);
    }

    @When("the member leaves the {string} field blank")
    public void theMemberLeavesTheFieldBlank(String fieldName) {

        logger.info("⚙️Leaving '{}' field blank", fieldName);

        registrationPage.leaveFirstNameFieldBlank();

        logger.info("✅Field '{}' left blank successfully", fieldName);
    }

    @Then("the inline error message {string} should be displayed")
    public void theInlineErrorMessageShouldBeDisplayed(String expectedMessage) {

        logger.info("⚙️Validating inline error message");

        Assert.assertTrue(
                registrationPage.isFirstNameRequiredErrorDisplayed(),
                "Expected error message is not displayed"
        );

        String actualMessage =
                registrationPage.getFNameFieldRequiredErrorTxt();

        logger.info("🔎Expected message: {}", expectedMessage);
        logger.info("🔎Actual message: {}", actualMessage);

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Inline error message mismatch"
        );

        logger.info("✅Inline error message validation passed");
    }
}