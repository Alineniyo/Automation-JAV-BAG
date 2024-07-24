package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Timesheet extends FW_Page {

private static final String LO_LNK_NAV_DASHBOARD_TIME = "//a[@href='/web/index.php/time/viewTimeModule']";
private static final String LO_TXT_TIMESHEET = "//span[contains(text(),'Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET = "//a[contains(text(),'My Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET_VALIDATE = "//a[contains(text(),'My Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET_CALENDAR= "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']";
private static final String LO_BTN_EDIT= "//button[@class='oxd-button oxd-button--medium oxd-button--ghost']";
private static final String LO_TXT_CALENDAR= "//div[@class='oxd-calendar-wrapper']";
private static final String LO_TXT_CALENDAR_MONTH= "//li[@class='oxd-calendar-selector-month']";
private static final String LO_TXT_CALENDAR_MONTH_PICK= "//li[contains(text(),'August')]";
private static final String LO_TXT_CALENDAR_MONTH_DISPLAY= "//ul[@class='oxd-calendar-dropdown']";
private static final String LO_TXT_CALENDAR_DATE_DAY= "//div[contains(text(),'25')]";



    public PO_Timesheet(WebDriver driver) {
        super(driver);
    }



    public String clickTime() {
        String result = clickLocator(LO_LNK_NAV_DASHBOARD_TIME, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String clickTimesheet() {
        String result = clickLocator(LO_TXT_TIMESHEET, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String clickMyTimesheets() {
        String result = clickLocator(LO_TXT_MY_TIMESHEET, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String validateOnPage() {
        String result = validateLocatorExists(LO_TXT_MY_TIMESHEET_VALIDATE,FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;

    }



    public String clickMCalendarIcon() {
        String result = clickLocator(LO_TXT_MY_TIMESHEET_CALENDAR, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String clickEditButton() {
        String result = clickLocator(LO_BTN_EDIT, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String clickCalendar() {
        String result = validateLocatorExists(LO_TXT_CALENDAR, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String pickMonth() {
        String result = clickLocator(LO_TXT_CALENDAR_MONTH, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }



    public String pickMonthSelect() {
        String result = clickLocator(LO_TXT_CALENDAR_MONTH_PICK, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }



    public String pickMonthDisplay() {
        String result = validateLocatorExists(LO_TXT_CALENDAR_MONTH_DISPLAY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String pickDateDay() {
        String result = clickLocator(LO_TXT_CALENDAR_DATE_DAY, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result; 
    }



}

   

  





