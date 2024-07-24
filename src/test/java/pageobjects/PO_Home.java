package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Home extends FW_Page {

private static final String LO_LNK_AUTHENTICATION_HOME = "//div[@class='oxd-sidepanel-header']//a[@class='oxd-brand']";
private static final String LO_BUT_COLLAPSE = "//i[@class='oxd-icon bi-chevron-left']";
private static final String LO_BUT_EXPAND = "//i[@class='oxd-icon bi-chevron-right']";
//private static final String LO_BUT_ADMIN = "//li[@class='oxd-main-menu-item-wrapper']//a[@class='oxd-main-menu-item active toggle']";
private static final String LO_LNK_ADMIN = "//span[normalize-space()='Admin']";
private static final String LO_BUT_SEARCH = "//input[@placeholder='Search']";
private static final String LO_BUT_PIM = "//span[normalize-space()='PIM']";
private static final String LO_BUT_LEAVE = "//span[normalize-space()='Leave']";
private static final String LO_BUT_VALIDATE_ADMIN = "//span[normalize-space()='Admin']";



    public PO_Home(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_AUTHENTICATION_HOME, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickLeftSidebarShrink() {
        String result = clickLocator(LO_BUT_COLLAPSE, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickLeftSidebarExpand() {
        String result = clickLocator(LO_BUT_EXPAND, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickAdmin() {
        String result = clickLocator(LO_LNK_ADMIN, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateSearch() {
        String result = validateLocatorExists(LO_BUT_SEARCH, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validatePIM() {
        String result = validateLocatorExists(LO_BUT_PIM, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateLeave() {
        String result = validateLocatorExists(LO_BUT_LEAVE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateAdmin() {
        String result = validateLocatorExists(LO_BUT_VALIDATE_ADMIN, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    

}