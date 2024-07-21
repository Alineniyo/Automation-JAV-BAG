package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_StringUtils;

public class PO_Dashboard extends FW_Page {

private static final String LO_LNK_NAV_DASHBOARD_VALIDATE = "//span[@class='oxd-topbar-header-breadcrumb']//h6";
private static final String LO_LNK_NAV_DASHBOARD_TIME = "//a[@href='/web/index.php/time/viewTimeModule']";


    public PO_Dashboard(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_NAV_DASHBOARD_VALIDATE, 10, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String clickTime() {
        String result = clickLocator(LO_LNK_NAV_DASHBOARD_TIME, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

  


}

