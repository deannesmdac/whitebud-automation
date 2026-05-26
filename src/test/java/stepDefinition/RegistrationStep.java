package stepDefinition;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import page.RegistrationPage;
import hooks.Hooks;
import io.cucumber.java.en.Given;

public class RegistrationStep {

   private final RegistrationPage registrationPage = Hooks.getPageManager().getRegistrationPage();

    @Given("Member navigates to the SMAC Web Registration Portal")
    public void memberNavigatesToTheSMACWebRegistrationPortal() {
        registrationPage.openUrl("https://awsstgexternal-outsys.smadvantage.com/SMACOnlineAcquisition/");
    }

    @Then("the {string} portal is displayed")
    public void theSMACWebPortalIsDisplayed(String arg0) {
        Assert.assertTrue(registrationPage.smacRegistrationTitleIsDisplayed());
        Assert.assertTrue(registrationPage.detailsTabIsDisplayed());
    }
}
