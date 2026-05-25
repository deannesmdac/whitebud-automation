package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features/whitebudRegistration.feature",   // path to your .feature files
        glue = {"stepDefinition", "hooks"},        // step definitions + hooks
        plugin = {"pretty"
                //"json:target/cucumber-json/initial/account.json", //Machine-readable, for merging reports, rerun handling, and CI dashboards.
                //"rerun:target/rerun-txt/initial/rerun-account.txt"   // <-- automatically logs failed scenarios
        },
        monochrome = true
)


public class RegistrationRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
