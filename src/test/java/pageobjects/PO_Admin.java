package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Admin extends FW_Page {

private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_VALIDATE = "//span[@class='oxd-topbar-header-breadcrumb']//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-level']";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_JOB = "//span[contains(text(),'Job')]";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_ORGANIZATION = "//span[contains(text(),'Organization')]";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_QUALIFICATION = "//span[contains(text(),'Qualifications')]";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_NATIONALITY = "//a[contains(text(),'Nationalities')]";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_CORPORATE_BRANDING = "//a[contains(text(),'Corporate Branding')]";
private static final String LO_LNK_NAV_EXPLORATORY_ADMIN_MORE = "//span[contains(text(),'More')]";
private static final String LO_BUT_NAV_EXPLORATORY_ADMIN_QUESTION = "//div[@class='oxd-topbar-body-nav-slot']//button[@type='button']";
private static final String LO_BUT_NAV_EXPLORATORY_ADMIN_USERNAME_PROFILE= "//span[@class='oxd-userdropdown-tab']";



    public PO_Admin(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }



    public String validateJob() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_JOB, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateOrganization() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_ORGANIZATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateQualification() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_QUALIFICATION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String validateNationalities() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_NATIONALITY, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateCorporateBranding() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_CORPORATE_BRANDING, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateMore() {
        String result = validateLocatorExists(LO_LNK_NAV_EXPLORATORY_ADMIN_MORE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateQuestionButton() {
        String result = validateLocatorExists(LO_BUT_NAV_EXPLORATORY_ADMIN_QUESTION, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


    public String validateUsernameProfile() {
        String result = validateLocatorExists(LO_BUT_NAV_EXPLORATORY_ADMIN_USERNAME_PROFILE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
        
    }

}


