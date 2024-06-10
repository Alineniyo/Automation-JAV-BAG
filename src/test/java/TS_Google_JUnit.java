// JUnit 5
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

// Selenium WebDriver
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

// Automation framework
import framework.assertions.FW_CustomAssertJU;
import framework.audits.FW_Audit_Connectivity;
import framework.audits.FW_Audit_Sandbox;
import framework.automation.FW_Network;
import framework.driver.FW_Browser;
import framework.formatter.FW_TestSuiteFormatter;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_ReportUtils;
import framework.utilities.FW_ScreenUtils;

// Page Objects - [Note: Automation Engineer, import Page Object (PO) for this Test Suite (TS) here.
import pageobjects.PO_Home;
import pageobjects.PO_Results;

/**
 * [Note: Automation Engineer, provide a description of this Test Suite (TS) here.]
 * <p>
 * Test suite for Google functionality.
 * This suite includes tests for various features and behaviors of the SwagLabs sample application.
 * <p>
 * It uses the JUnit testing framework and utilizes the Page Object (PO) design pattern.
 * It also uses a custom assertion class called FW_CustomAssertJU and the autoPass() method specificly designed
 * for this test automation framework, allowing specific details to be returned from individual test steps.
 */
// [Note: Automation Engineer, rename this class to match this Test Suite (TS) filename.]
public class TS_Google_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;
    
    // Declare Page Object (PO) variables [Note: Automation Engineer add page objects here.]
    PO_Home po_Home;
    PO_Results po_Results;

    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_Google_JUnit() {
        // Default constructor
    }

    // ================================================================================
    /**
     * Define what happens before entire Test Suite (TS) executes.
     */
    @BeforeAll
    public static void setupTestSuite() {
        // Create an anonymous object and get the simple name of its enclosing class
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
    
        // Call the beforeAll method of FW_TestSuiteFormatter with the class name
        FW_TestSuiteFormatter.beforeAll(className);
    
        // Load testConfig.properties for Test Suite and all Test Cases
        FW_ConfigMgr.getInstance();
    }

    // ================================================================================
    /**
     * Define what happens before each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @BeforeEach
    public void setupTestCase(TestInfo testInfo) {
        FW_TestSuiteFormatter.beforeEach(testInfo);

        // Instantiate framework variables for this Test Case
        ao_Audit_Connectivity = new FW_Audit_Connectivity();
        ao_Audit_Sandbox = new FW_Audit_Sandbox();
        fw_Network = new FW_Network();

        // Create WebDriver for Test Case
        driver = FW_Browser.createWebDriver();

        // [Note: Automation Engineer, instantiate Page Object (PO) class(es) for all Test Cases (TC) here.]
        po_Home = new PO_Home(driver);
        po_Results = new PO_Results(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for Google search for "Apple".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Apple")
    public void tc_google_search_for_apple() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("TOM AND JERRY"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
        FW_ScreenUtils.takeScreenshot(driver, "Sample", FW_ConfigMgr.getScreenCaptureDirectory());
    }

    /**
     * Test Case (TC) for Google search for "Covid-19".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Covid-19")
    public void tc_google_search_for_covid() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("covid-19"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google search for "Florida".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Florida")
    public void tc_google_search_for_florida() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Florida"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google search for "Rwanda".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Rwanda")
    public void tc_google_search_for_rwanda() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Rwanda"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google search for "Bora Bora".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Bora Bora")
    public void tc_google_search_for_bora_bora() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Bora Bora"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google search for "Indiana".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Indiana")
    public void tc_google_search_for_indiana() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Indiana"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google search for "Kigali Rwanda".
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Kigali Rwanda")
    public void tc_google_search_for_kilali_rwanda() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Kigali Rwanda"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    /**
     * Test Case (TC) for Google using im feeling lucky.
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - I'm Feeling Lucky")
    public void tc_google_im_feeling_lucky() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.scroll_to_feeling_trendy_or_puzzled_or_curious());
        // Pick it up here
    }
    /**
     * Test case (TC) for Google Search for "Netflix"
     * @param testInfo
     */
    @Test
    @Tag("e2e_test")
    @DisplayName("TC - Google - Search for Netflix")
    public void tc_google_search_for_Netflix() {
        FW_CustomAssertJU.autoPass(po_Home.navigateTo("https://www.google.com"));
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage());
        FW_CustomAssertJU.autoPass(po_Home.enterSearch("Netflix"));
        FW_CustomAssertJU.autoPass(po_Home.clickBaseGoogleSearch());
        FW_CustomAssertJU.autoPass(po_Results.validateOnPage());
    }

    // ================================================================================
    /**
     * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
     * 
     * @param testInfo Information about the current test, provided by JUnit.
     */
    @AfterEach
    public void tearDownEach(TestInfo testInfo) {
        FW_TestSuiteFormatter.afterEach(testInfo);

        // Dispose WebDriver for Test Case
        FW_Browser.disposeWebDriver(driver);
    }

    // ================================================================================
    /**
     * Define what happens before all Test Case (TC) in this Test Suite (TS) is
     * executed.
     */
    @AfterAll
    public static void tearDownTestSuite() {
        String className = new Object() {
        }.getClass().getEnclosingClass().getSimpleName();
        FW_TestSuiteFormatter.afterAll(className);
    }
}
