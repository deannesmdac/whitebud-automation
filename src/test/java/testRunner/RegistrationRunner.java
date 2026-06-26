package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


@CucumberOptions(

        // Path to feature files
        features = "src/test/resources/features/whitebudRegistration.feature",

        // Packages containing step definitions and hooks
        glue = {"stepDefinition", "hooks"},

        // Reporting plugins
        plugin = {

                // Console output
                "pretty",

                // Generates HTML report
//                "html:target/cucumber-report.html",

                //"html:target/cucumber-reports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",

                // Generates JSON report
                "json:target/cucumber.json"

                // Additional optional plugins:

                // Machine-readable report for CI/CD integration
                // "json:target/cucumber-json/initial/account.json",

                // Stores failed scenarios for rerun execution
                // "rerun:target/rerun-txt/initial/rerun-account.txt"
        },

        // Makes console output cleaner and more readable
        monochrome = true
)

public class RegistrationRunner extends AbstractTestNGCucumberTests {

    /**
     * Controls scenario execution.
     *
     * parallel = false
     * → scenarios run one at a time
     *
     * parallel = true
     * → scenarios run simultaneously
     */
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {

        return super.scenarios();
    }
}