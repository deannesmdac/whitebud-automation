package report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentManager {

    private static ExtentReports extent;
    private static String reportPath;

    private ExtentManager() {
        // Prevent instantiation
    }

    public static ExtentReports getInstance() {

        if (extent == null) {

            // Generate timestamp
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss")
                    .format(new Date());

            // Save report path
            reportPath = "test-output/ExtentReport_" + timeStamp + ".html";

            // Create Spark Reporter
            ExtentSparkReporter spark =
                    new ExtentSparkReporter(reportPath);

            spark.config().setDocumentTitle("Whitebud Automation Report");
            spark.config().setReportName("Whitebud Regression Suite");

            // Create Extent Report
            extent = new ExtentReports();
            extent.attachReporter(spark);

            // System Information
            extent.setSystemInfo("Project", "Whitebud Automation");
            extent.setSystemInfo("Tester", "Deanne");
            extent.setSystemInfo("Framework", "Selenium + Cucumber + TestNG");
            extent.setSystemInfo("Language", "Java 17");
            extent.setSystemInfo("Browser", "Chrome");
        }

        return extent;
    }

    /**
     * Returns the generated report location.
     */
    public static String getReportPath() {
        return reportPath;
    }

    /**
     * Flushes the report safely.
     */
    public static void flush() {

        if (extent != null) {
            extent.flush();
        }
    }
}