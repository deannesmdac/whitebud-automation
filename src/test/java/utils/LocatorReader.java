package utils;

import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileReader;

public class LocatorReader {

    private static final String FILE_PATH =
            "src/test/resources/testdata/locators.csv";

    public static By getLocator(String LocatorName) {

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {

            br.readLine(); // Skip header

            String line;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",", -1);

                if (values[0].equals(LocatorName)) {

                    String locatorType = values[1];
                    String locatorValue = values[2];

                    switch (locatorType.toLowerCase()) {

                        case "id":
                            return By.id(locatorValue);

                        case "name":
                            return By.name(locatorValue);

                        case "xpath":
                            return By.xpath(locatorValue);

                        case "css":
                            return By.cssSelector(locatorValue);

                        case "class":
                            return By.className(locatorValue);

                        case "tag":
                            return By.tagName(locatorValue);

                        case "linktext":
                            return By.linkText(locatorValue);

                        case "partiallinktext":
                            return By.partialLinkText(locatorValue);

                        default:
                            throw new IllegalArgumentException(
                                    "Unsupported locator type: " + locatorType);
                    }
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Unable to read locator CSV", e);
        }

        throw new RuntimeException("Locator not found: " + LocatorName);
    }
}