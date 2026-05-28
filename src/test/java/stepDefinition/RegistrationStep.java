package stepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import page.RegistrationPage;
import hooks.Hooks;
import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RegistrationStep {

   private final RegistrationPage registrationPage = Hooks.getPageManager().getRegistrationPage();

    private static final Logger logger =
            LoggerFactory.getLogger(RegistrationStep.class);

    @Given("Member navigates to the SMAC Web Registration Portal")
    public void memberNavigatesToTheSMACWebRegistrationPortal() {

        registrationPage.openUrl("https://awsstgexternal-outsys.smadvantage.com/SMACOnlineAcquisition/");
    }

    @Then("the {string} portal is displayed")
    public void theSMACWebPortalIsDisplayed(String arg0) {

        //SMAC Registration Title is displayed checking
        try{
            Assert.assertTrue(registrationPage.isSmacRegistrationPageDisplayed());
            logger.info("PASS: SMAC Registration Portal is displayed");

        } catch (Exception e) {
            logger.error("FAIL: SMAC Registration Portal is not displayed");
            throw e;
        }



    }
}
