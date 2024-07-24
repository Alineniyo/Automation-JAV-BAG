package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Logout extends FW_Page {

private static final String LO_LNK_AUTHENTICATION_LOGOUT_VALIDATE = "//a[contains(text(),'Logout')]";
private static final String LO_LST_USER_LOGOUT = "//a[@href='/web/index.php/auth/logout']";
private static final String LO_LST_USER = "//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']";


    public PO_Logout(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_AUTHENTICATION_LOGOUT_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickDropDownIcon() {
        String result = clickLocator(LO_LST_USER, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickLogout() {
        String result = clickLocator(LO_LST_USER_LOGOUT, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


}
