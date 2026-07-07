package stepDefinition;

import hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import page.RegistrationPage;
import report.ReportLogger;
import utils.TestDataReader;
import java.util.Map;
import java.util.Objects;

public class RegistrationStep {

    private final RegistrationPage registrationPage =
            Hooks.getPageManager().getRegistrationPage();

    @Given("Member navigates to the SMAC Web Registration Portal")
    public void memberNavigatesToTheSMACWebRegistrationPortal() {

        ReportLogger.info("Navigating to SMAC Registration Portal");

        try {
            registrationPage.openUrl(
                    "https://awsuat-outsys.smadvantage.com/smaconlineacquisition/"
            );

            ReportLogger.pass("Successfully opened SMAC Registration Portal");

        } catch (Exception e) {
            ReportLogger.fail(
                    "Failed to open SMAC Registration Portal. Error: " + e.getMessage()
            );
        }
    }

    @Then("the {string} portal is displayed")
    public void thePortalIsDisplayed(String portalName) {

        ReportLogger.info("Verifying portal: " + portalName);

        try {
            if (!registrationPage.isRegistrationPageDisplayed()) {
                ReportLogger.fail(portalName + " portal is not displayed.");
            }

            ReportLogger.pass(portalName + " displayed successfully");

        } catch (Exception e) {
            ReportLogger.fail(
                    "Error while verifying " + portalName + " portal: " + e.getMessage()
            );
        }
    }

    @When("the member enters registration details for {string}")
    public void theMemberEntersRegistrationDetailsFor(String testCaseName) {

        ReportLogger.info("Loading test data: " + testCaseName);

        Map<String, String> data =
                TestDataReader.getTestData(testCaseName);

        registrationPage.enterFirstNameField(data.get("FirstName"));
        registrationPage.enterLastNameField(data.get("LastName"));
        registrationPage.enterBirthdayField(data.get("Birthday"));
        registrationPage.enterMobileNumberField(data.get("MobileNumber"));
        registrationPage.enterEmailField(data.get("EmailAddress"));
        registrationPage.enterPasswordField(data.get("Password"));
        registrationPage.enterConfirmPasswordField(data.get("ConfirmPassword"));

        ReportLogger.pass("Registration details entered successfully");
    }

     @Then("the Link Card Page should be displayed")
    public void theLinkCardTabShouldBeDisplayed() {

        ReportLogger.info("Verifying Link Card page");

        Assert.assertTrue(
                registrationPage.linkCarPageDisplayed(),
                "Link Card Page is not displayed."
        );

        ReportLogger.pass("Link Card Page displayed successfully");
    }

    @Then("the inline error message {string} is displayed")
    public void theInlineErrorMessageIsDisplayed(String testCaseName) {

        ReportLogger.info("Validating inline error message for: " + testCaseName);

        Map<String, String> data =
                TestDataReader.getTestData(testCaseName);

        String actualMessage = registrationPage.getFieldNameByTestCase(testCaseName);
        String expectedMessage = data.get("ErrorMessage");

        ReportLogger.info("Expected: " + expectedMessage);
        ReportLogger.info("Actual: " + actualMessage);

        if (!Objects.equals(actualMessage, expectedMessage)) {
            ReportLogger.warning(
                    "Inline error message mismatch. Expected:'{}', Actual:'{}'",
                    expectedMessage,
                    actualMessage
            );
        }

        Assert.assertEquals(
                actualMessage,
                expectedMessage,
                "Inline error message mismatch."
        );

        ReportLogger.pass("Inline error message validated successfully");
    }

    @Then("the proceed button is {string}")
    public void theProceedButtonIsNotClickable(String state) {
        switch (state) {

            case "not clickable":
                String isProceedDisabled = registrationPage.checkDisable_ProceedButtonDP();

                ReportLogger.info("Verifying Proceed button if not clickable");

                Assert.assertEquals(isProceedDisabled,"disabled",
                        "Proceed button is clickable");

                ReportLogger.pass("Proceed button is clickable");
                break;

            case "clickable":
                 String isProceedEnabled = registrationPage.checkDisable_ProceedButtonDP();

                ReportLogger.info("Verifying Proceed button if not clickable");

                Assert.assertNull(isProceedEnabled,
                        "Proceed button is not clickable");

                ReportLogger.pass("Proceed button is not clickable");
                break;

            default:
                Assert.fail("State Unknown: " + state);

        }


    }


    @Then("the {string} password criteria is enabled")
    public void thePasswordCriteriaIsDisabled(String passwordCriteria) {
        ReportLogger.info("Verifying if the password criteria is enabled");

        Assert.assertTrue(registrationPage.isPasswordRuleActive(passwordCriteria));

        ReportLogger.info("Successfully verified that the password criteria is enabled");
    }

    @Then("no inline error message is displayed for {string}")
    public void theNoInlineErrorMessageIsDisplayedFor(String testCaseName) {
        ReportLogger.info("Validating no inline error message for: " + testCaseName);

        String fieldName = registrationPage.getFieldNameByTestCase(testCaseName);

        boolean isErrorDisplayed = registrationPage.isInlineErrorDisplayed(fieldName);

        ReportLogger.info("Inline error displayed: " + isErrorDisplayed);

        if (isErrorDisplayed) {
            String actualMessage = registrationPage.getInlineErrorByField(fieldName);

            ReportLogger.warning(
                    "Unexpected inline error message displayed: '{}'",
                    actualMessage
            );
        }

        Assert.assertFalse(
                isErrorDisplayed,
                "Inline error message should not be displayed."
        );

        ReportLogger.pass("No inline error message is displayed.");
    }

    @And("the member scrolls to the {string}")
    public void theMemberScrollsToThe(String LocatorName) {
        ReportLogger.info("Verifying page scrolls to the First Name field");

        registrationPage.scrollToLocator(LocatorName);

        ReportLogger.pass("Successfully scrolled to First Name field");

    }

    @And("the member clicks the {string}")
    public void theMemberClicksThe(String LocatorName) {
        String checkEnabled =registrationPage.checkDisable_ProceedButtonDP();

        Assert.assertNull(checkEnabled);

        ReportLogger.info("Verifying if locator is clickable");

        registrationPage.clickLocator(LocatorName);

        ReportLogger.pass("Successfully clicked the locator");
    }

    @And("the member ticks the SMAC Terms&Conditions and Data Privacy Policy")
    public void theMemberTicksTheSMACSHOPUpdateAndTermsConditions() {
        ReportLogger.info("Verifying page scrolls to the First Name field");

        registrationPage.clickConsentCheckbox();

        ReportLogger.pass("Successfully scrolled to First Name field");
    }
}
