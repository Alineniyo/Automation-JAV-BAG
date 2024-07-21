package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_StringUtils;

public class PO_Reset_Pwd extends FW_Page {

private static final String LO_LNK_AUTHENTICATION_RESETPWD_PAGE_VALIDATION = "//h6[@class='oxd-text oxd-text--h6 orangehrm-forgot-password-title']";
private static final String LO_LNK_AUTHENTICATION_RESETPWD_USERNAME = "//input[@name='username']";
private static final String LO_BTN_AUTHENTICATION_RESETPWD = "//button[@class='oxd-button oxd-button--large oxd-button--secondary orangehrm-forgot-password-button orangehrm-forgot-password-button--reset']";


    public PO_Reset_Pwd(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_AUTHENTICATION_RESETPWD_PAGE_VALIDATION, 10, 1);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickForgotYourPassword() {
        String result = clickLocator(LO_LNK_AUTHENTICATION_RESETPWD_USERNAME, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }
    public String enterUserName(String name){
        String result = setText(LO_LNK_AUTHENTICATION_RESETPWD_USERNAME, name, 10, false);
        typeOnKeyboard("TAB"); // Close the dropdown if it exists
        return result;

}

    public String clickResetPassword() {
        String result = clickLocator(LO_BTN_AUTHENTICATION_RESETPWD, 10);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }}
