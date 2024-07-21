package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_StringUtils;

public class PO_Timesheet extends FW_Page {

private static final String LO_LNK_NAV_DASHBOARD_TIME = "//a[@href='/web/index.php/time/viewTimeModule']";
private static final String LO_TXT_TIMESHEET = "//span[contains(text(),'Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET = "//a[contains(text(),'My Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET_VALIDATE = "//a[contains(text(),'My Timesheets')]";
private static final String LO_TXT_MY_TIMESHEET_CALENDAR= "//i[@class='oxd-icon bi-calendar oxd-date-input-icon']";


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
        String result = validateLocatorExists(LO_TXT_MY_TIMESHEET_VALIDATE, 10,1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;

    }



    public String clickMCalendarIcon() {
        String result = clickLocator(LO_TXT_MY_TIMESHEET_CALENDAR, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    }

   

  





