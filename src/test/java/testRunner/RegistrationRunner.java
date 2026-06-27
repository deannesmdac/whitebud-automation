package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(

        // Feature files
        features = "src/test/resources/features/whitebudRegistration.feature",

        // Step Definitions + Hooks
        glue = {
                "stepDefinition",
                "hooks"
        },

        // Reports
        plugin = {
                "pretty",
                "html:target/cucumber-report.html",
                "json:target/cucumber.json"
        },

        monochrome = true,
        publish = false
)

public class RegistrationRunner extends AbstractTestNGCucumberTests {

    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}