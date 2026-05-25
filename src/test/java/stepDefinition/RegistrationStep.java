package stepDefinition;

import Page.RegistrationPage;
import hooks.Hooks;
import io.cucumber.java.en.Given;

public class RegistrationStep {

   private final RegistrationPage registrationPage = Hooks.getPageManager().getRegistrationPage();

    @Given("Member access SMAC Web Registration portal")
    public void member_access_web_registration_portal() {
        registrationPage.openUrl("https://awsstgexternal-outsys.smadvantage.com/SMACOnlineAcquisition/");
    }
}
