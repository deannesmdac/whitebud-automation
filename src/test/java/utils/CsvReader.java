package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CsvReader {

    private static final String FILE_PATH =
            "src/test/resources/testdata/registration.csv";

    public static Map<String, String> getTestData(String testCaseName) {

        try (BufferedReader br =
                     new BufferedReader(new FileReader(FILE_PATH))) {

            String[] headers = br.readLine().split(",");

            String line;

            while ((line = br.readLine()) != null) {

                String[] values = line.split(",", -1);

                if (values[0].equals(testCaseName)) {

                    Map<String, String> data = new HashMap<>();

                    for (int i = 0; i < headers.length; i++) {
                        data.put(headers[i], values[i]);
                    }

                    return data;
                }
            }

        } catch (Exception e) {
            throw new RuntimeException(
                    "Unable to read CSV file",
                    e
            );
        }

        throw new RuntimeException(
                "Test case not found: " + testCaseName
        );
    }
}