// This code for the JUnit custom assertion
package framework.assertions;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.junit.jupiter.api.Assertions;

// Automation framework
import framework.utilities.FW_ConfigMgr;
//import framework.utilities.FW_ReportUtils;
import framework.utilities.FW_ScreenUtils;
import framework.reporting.FW_AllureAnnotationStepPass;
import framework.reporting.FW_AllureAnnotationStepPassWarnLow;
import framework.reporting.FW_AllureAnnotationStepPassWarnMedium;
import framework.reporting.FW_AllureAnnotationStepPassWarnHigh;
import framework.reporting.FW_AllureAnnotationStepPassWarnCritical;
import framework.reporting.FW_AllureAnnotationStepFail;

// Automation Reporting
import io.qameta.allure.Allure;

// Regular Expressions
import java.util.regex.Pattern;
import java.util.regex.Matcher;

// Java file I/O
// import java.io.IOException;
// import java.nio.file.Paths;
// import java.nio.file.Files;

/**
 * This class is used to create custom assertion specific for our autoamtion framework utilizing JUnit.
 */
public class FW_CustomAssertJU {

    // Declare ANSI escape sequences for formatting console output colors
    static String black =       "\033[0;30m";            // BLACK
    static String brown =       "\033[38;5;94m";         // BROWN
    static String red =         "\033[38;2;255;0;0m";    // RED
    static String pink =        "\033[38;2;255;193;203m";// PINK
    static String coral =       "\033[38;2;255;127;80m"; // CORAL
    static String orange =      "\033[38;2;255;165;0m";  // ORANGE
    static String yellow =      "\033[38;2;255;255;0m";  // YELLOW
    static String green =       "\033[38;2;0;128;1m";    // GREEN
    static String greenyellow = "\033[38;2;173;255;47m"; // GREEN YELLOW
    static String blue =        "\033[0;34m";            // BLUE
    static String violet =      "\033[0;35m";            // VIOLET
    static String grey =        "\033[0;37m";            // GREY
    static String darkGrey =    "\033[0;90m";            // DARK GREY
    static String white =       "\033[0;97m";            // WHITE
    static String reset =       "\033[0m";               // Text Reset

    /**
     * Default constructor.
     */
    public FW_CustomAssertJU() {
        // Default constructor
    }

    // Declare WebDriver instance at class level
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    // Modify the setDriver method
    public static void setDriver(WebDriver driverInstance) {
        driver.set(driverInstance);
    }

    // Add a method to get the driver
    public static WebDriver getDriver() {
        return driver.get();
    }

    /**
     * Asserts that the given result string contains either "[Pass]" or "[Fail]".
     * If the result is null, the test fails immediately.
     * If the result contains "[Pass]", the test passes.
     * If the result contains "[Fail]", the test fails.
     * If the result contains neither "[Pass]" nor "[Fail]", the test fails with a warning about invalid formatting.
     *
     * @param result the result string to check
     * *
     * @return the result passed into the method
     */
    public static String autoPass(String result) {

        Pattern pattern = Pattern.compile("\\[.*?\\]");
        Matcher matcher = pattern.matcher(result);
        
        String resultOnly = "";
        if (matcher.find()) {
            resultOnly = matcher.group();
        }

        // Handle null result
        if (result == null) {
            result = "[Fail]: Result is null.";
            stepFail(result);
            return result;
        }

        // Handle [Audit Pass] result
        if (resultOnly.toUpperCase().contains("[AUDIT PASS]")) {
            System.out.println(green + result +  reset);
            Assertions.assertTrue(true);

        // Handle [Audit Fail] result
        } else if (resultOnly.toUpperCase().contains("[AUDIT FAIL]")) {
            System.out.println(red + result + reset);
            Assertions.fail(result);

        // Handle [Pass] result
        } else if (resultOnly.toUpperCase().contains("[PASS]")) {
            stepPass(result);

        // Handle [Pass Warn - Low] result
        } else if (resultOnly.toUpperCase().contains("[PASS WARN - LOW]")) {
            stepPassWarnLow(result);

        // Handle [Pass Warn - Medium] result
        } else if (resultOnly.toUpperCase().contains("[PASS WARN - MEDIUM]")) {
            stepPassWarnMedium(result);

        // Handle [Pass Warn - High] result
        } else if (resultOnly.toUpperCase().contains("[PASS WARN - HIGH]")) {
            stepPassWarnHigh(result);

        // Handle [Pass Warn - Critical] result
        } else if (resultOnly.toUpperCase().contains("[PASS WARN - CRITICAL]")) {
            stepPassWarnCritical(result);

        // Handle [Fail] result
        } else if (resultOnly.toUpperCase().contains("[FAIL]")) {
            stepFail(result);

        // Handle missing Meta tag
        } else {
            System.out.println(yellow + "[Warn]: Invalid formatting of test result '" + result + "' which should contain either '[Pass]' or '[Fail]'." + reset);
            Assertions.fail("[Warn]: Invalid formatting of test result '" + result + "' which should contain either '[Pass]' or '[Fail]'.");
        }

        return result;
    }

    /**
     * The stepPass method is used to send the pass step details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepPass("Step: {0}")
    private static void stepPass(String result) {
        System.out.println(green + result + reset);

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = pass
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("pass")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Pass", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Pass the test
            Assertions.assertTrue(true);
        });
    }

    /**
     * The stepPassWarnLow method is used to send the details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepPassWarnLow("Step: {0}")
    private static void stepPassWarnLow(String result) {
        System.out.println(greenyellow + result + reset);

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnlow
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnlow")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Low", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Pass the test
            Assertions.assertTrue(true);
        });
    }

    /**
     * The stepPassWarnMedium method is used to send the details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepPassWarnMedium("Step: {0}")
    private static void stepPassWarnMedium(String result) {
        System.out.println(yellow + result + reset);

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnmedium
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnmedium")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Medium", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Pass the test
            Assertions.assertTrue(true);
        });
    }

    /**
     * The stepPassWarnHigh method is used to send the details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepPassWarnHigh("Step: {0}")
    private static void stepPassWarnHigh(String result) {
        System.out.println(orange + result + reset);

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warnhigh
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warnhigh")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-High", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Pass the test
            Assertions.assertTrue(true);
        });
    }

    /**
     * The stepPassWarnCritical method is used to send the details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepPassWarnCritical("Step: {0}")
    private static void stepPassWarnCritical(String result) {
        System.out.println(coral + result + reset);

        // Set pass context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = warncritical
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("warncritical")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Pass-Warn-Critical", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Pass the test
            Assertions.assertTrue(true);
        });
    }

    /**
     * The stepResult method is used to send the step details to the Allure report and listener.
     * @param result
     */
    @FW_AllureAnnotationStepFail("Step: {0}")
    private static void stepFail(String result) {
        System.out.println(red + result + reset);

        // Set fail context for the Allure reporting
        Allure.step("Step: " + result, () -> {

            // Take a screenshot if screenCaptureOnTestStepResults = true and screenCaptureOnTestStepResultsSelection = fail
            if (FW_ConfigMgr.getScreenCaptureOnTestStepResults().toLowerCase().contains("true")) {
                if (FW_ConfigMgr.getScreenCaptureOnTestStepResultsSelection().toLowerCase().contains("fail")) {
                    FW_ScreenUtils.takeScreenshot(getDriver(), "Fail", FW_ConfigMgr.getScreenCaptureDirectory());
                }
            }

            // Fail the test
            Assertions.fail(result);
        });
    }

}