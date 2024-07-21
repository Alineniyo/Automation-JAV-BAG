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
import pageobjects.PO_Dashboard;
// Page Objects - [Note: Automation Engineer, import Page Object (PO) for this Test Suite (TS) here.
import pageobjects.PO_Home;
import pageobjects.PO_Login;
import pageobjects.PO_Dashboard;
import pageobjects.PO_Timesheet;
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
public class TS_ORANGEHRM_Navigation_JUnit {

    // Declare WebDriver variable for this Test Suite
    WebDriver driver;

    // Declare framework variables for this Test Suite
    FW_Audit_Connectivity ao_Audit_Connectivity;
    FW_Audit_Sandbox ao_Audit_Sandbox;
    FW_Network fw_Network;
    
    // Declare Page Object (PO) variables [Note: Automation Engineer add page objects here.]
    PO_Home po_Home;
    PO_Login po_Login;
    PO_Dashboard po_Dashboard;
    PO_Timesheet po_Timesheet;
    /**
     * Define the Test Suite (TS) constructor.
     */
    // Declare constructor [Note: Automation Engineer, rename (TS) to match the filename.]
    public TS_ORANGEHRM_Navigation_JUnit() {
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
        po_Login = new PO_Login(driver);
        po_Dashboard = new PO_Dashboard(driver);
        po_Timesheet = new PO_Timesheet(driver);
    }

    // ================================================================================
    // [Note: Automation Engineer, define Test Cases (TC) for this Test Suite (TS)

    /**
     * Test Case (TC) for navigation menu f
     */

    @Tag("e2e_test")
    @RepeatedTest(1)
    @DisplayName("TC - Bag - Navigation - Menu - Shrink")
    public void tc_bag_navigation_menu_shrink() {
        FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
        FW_CustomAssertJU.autoPass(po_Login.validateOnPage()); 
        FW_CustomAssertJU.autoPass(po_Login.clickUserName()); 
        FW_CustomAssertJU.autoPass(po_Login.enterUserName("Admin")); 
        FW_CustomAssertJU.autoPass(po_Login.clickUserPassword()); 
        FW_CustomAssertJU.autoPass(po_Login.enterUserPassword("admin123")); 
        FW_CustomAssertJU.autoPass(po_Login.clickLoginButton()); 
        FW_CustomAssertJU.autoPass(po_Home.validateOnPage()); 
        FW_CustomAssertJU.autoPass(po_Home.clickLeftSidebarShrink());
        FW_CustomAssertJU.autoPass(po_Home.clickAdmin());
        FW_CustomAssertJU.autoPass(po_Home.clickLeftSidebarExpand());
        FW_ScreenUtils.takeScreenshot(driver, "1st Shrink nav", FW_ConfigMgr.getScreenCaptureDirectory());
    }
//*********************************************************1st testcase ************************************************************************** 
@Tag("e2e_test")
@RepeatedTest(1)
@DisplayName("TC - Bag - Navigation - Menu ")
public void tc_bag_navigation_menu() {
    FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    FW_CustomAssertJU.autoPass(po_Login.validateOnPage()); 
    FW_CustomAssertJU.autoPass(po_Login.clickUserName()); 
    FW_CustomAssertJU.autoPass(po_Login.enterUserName("Admin")); 
    FW_CustomAssertJU.autoPass(po_Login.clickUserPassword()); 
    FW_CustomAssertJU.autoPass(po_Login.enterUserPassword("admin123")); 
    FW_CustomAssertJU.autoPass(po_Login.clickLoginButton()); 
    FW_CustomAssertJU.autoPass(po_Home.validateOnPage()); 
    FW_CustomAssertJU.autoPass(po_Home.validateSearch());
    FW_CustomAssertJU.autoPass(po_Home.validateAdmin());
    FW_CustomAssertJU.autoPass(po_Home.validatePIM());
    FW_CustomAssertJU.autoPass(po_Home.validateLeave());
    FW_ScreenUtils.takeScreenshot(driver, "2nd validate btns nav", FW_ConfigMgr.getScreenCaptureDirectory());
}
//*********************************************************2nd testcase ************************************************************************** 
@Tag("e2e_test")
@RepeatedTest(1)
@DisplayName("TC - Bag - Navigation - Menu - Dashboard - Timesheets ")
public void tc_bag_navigation_menu_dashboard_timesheets() {
    FW_CustomAssertJU.autoPass(po_Login.navigateTo("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
    FW_CustomAssertJU.autoPass(po_Login.validateOnPage());
    FW_CustomAssertJU.autoPass(po_Login.enterUserName("Admin"));     
    FW_CustomAssertJU.autoPass(po_Login.clickUserPassword()); 
    FW_CustomAssertJU.autoPass(po_Login.enterUserPassword("admin123"));
    FW_CustomAssertJU.autoPass(po_Login.clickLoginButton()); 
    FW_CustomAssertJU.autoPass(po_Dashboard.validateOnPage());  
    FW_CustomAssertJU.autoPass(po_Dashboard.clickTime()); 
    FW_CustomAssertJU.autoPass(po_Timesheet.clickTimesheet());  
    FW_CustomAssertJU.autoPass(po_Timesheet.validateOnPage());  
    FW_CustomAssertJU.autoPass(po_Timesheet.clickMyTimesheets());  
    FW_CustomAssertJU.autoPass(po_Timesheet.clickMCalendarIcon());  
    
//*********************************************************3rd testcase ************************************************************************** 

    // // ================================================================================
    // /**
    //  * Define what happens after each Test Case (TC) in this Test Suite (TS) is executed.
    //  * 
    //  * @param testInfo Information about the current test, provided by JUnit.
    //  */
    // @AfterEach
    // public void tearDownEach(TestInfo testInfo) {
    //     FW_TestSuiteFormatter.afterEach(testInfo);

    //     // Dispose WebDriver for Test Case
    //     FW_Browser.disposeWebDriver(driver);
    // }

    // // ================================================================================
    // /**
    //  * Define what happens before all Test Case (TC) in this Test Suite (TS) is
    //  * executed.
    //  */
    // @AfterAll
    // public static void tearDownTestSuite() {
    //     String className = new Object() {
    //     }.getClass().getEnclosingClass().getSimpleName();
    //     FW_TestSuiteFormatter.afterAll(className);
    // }
}

}
