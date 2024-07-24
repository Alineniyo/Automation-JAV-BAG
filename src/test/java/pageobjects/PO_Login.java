package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Login extends FW_Page {

    private static final String LO_FIELD_ORANGEHRM_LOGIN_VALIDATE = "//div[@class='orangehrm-login-branding']//img[@src='/web/images/ohrm_branding.png?v=1711595107870']";
    private static final String LO_FIELD_ORANGEHRM_LOGIN_USERNAME = "//input[@placeholder='Username']";
    private static final String LO_FIELD_ORANGEHRM_LOGIN_PASSWORD = "//input[@placeholder='Password']";
    private static final String LO_BTN_ORANGEHRM_LOGIN = "//button[@type='submit']";
    private static final String LO_BTN_ORANGEHRM_LOGIN_ERROR_MESSAGE = "//p[@class='oxd-text oxd-text--p oxd-alert-content-text']";
    private static final String LO_BTN_ORANGEHRM_AUTHENTICATION_FORGOT_PASSWORD = "//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']";
    private static final String LO_LNK_ORANGEHRM_SOCIALMEDIA_ORANGEHRMINC = "//a[contains(text(),'OrangeHRM, Inc')]";
    private static final String LO_LNK_ORANGEHRM_SOCIALMEDIA_LINKEDIN = "//a[@href='https://www.linkedin.com/company/orangehrm/mycompany/']";
    private static final String LO_LNK_ORANGEHRM_FACEBOOK = "//a[@href='https://www.facebook.com/OrangeHRM/']";
    private static final String LO_LNK_ORANGEHRM_TWITTER = "//a[@href='https://twitter.com/orangehrm?lang=en']";
    private static final String LO_LNK_ORANGEHRM_YOUTUBE = "//a[@href='https://www.youtube.com/c/OrangeHRMInc']";


    public PO_Login(WebDriver driver) {
        super(driver);
    }

    // Validating you are on the right page for OrangeHRM Loginpage
    public String validateOnPage(){
        String result = validateLocatorExists(LO_FIELD_ORANGEHRM_LOGIN_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
                result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                return result;

    }

    //Clicking for username and password authentication in placeholder

    public String enterUserName(String name){
        String result = setText(LO_FIELD_ORANGEHRM_LOGIN_USERNAME, name, 10, false);
        typeOnKeyboard("TAB"); // Close the dropdown if it exists
        return result;
    }

    public String clickUserName() {
            String result = clickLocator(LO_FIELD_ORANGEHRM_LOGIN_USERNAME, 10);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result ;
    
        }
        public String clickUserPassword() {
            String result = clickLocator(LO_FIELD_ORANGEHRM_LOGIN_PASSWORD, 10);
                    result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
                    return result ;
    
        }

        
        public String enterUserPassword(String password){
            String result = setText(LO_FIELD_ORANGEHRM_LOGIN_PASSWORD, password, 10, false);
            typeOnKeyboard("TAB"); // Close the dropdown if it exists
            return result;
        }

        public String clickLoginButton() {
          String result = clickLocator(LO_BTN_ORANGEHRM_LOGIN, 0);
          result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
          return result ;

        }

        public String CatchError() {
            String result = validateLocatorExists(LO_BTN_ORANGEHRM_LOGIN_ERROR_MESSAGE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result ;
        }

        public String clickForgotYourPassword() {
           String result = clickLocator(LO_BTN_ORANGEHRM_AUTHENTICATION_FORGOT_PASSWORD, 0);
           result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
           return result ;

        }

        public String clickOrangeHRMInc() {
            String result = clickLocator(LO_LNK_ORANGEHRM_SOCIALMEDIA_ORANGEHRMINC, 0);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String clickLinkedinIcon() {
            String result = clickLocator(LO_LNK_ORANGEHRM_SOCIALMEDIA_LINKEDIN, 0);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String clickFacebookIcon() {
            String result = clickLocator(LO_LNK_ORANGEHRM_FACEBOOK, 0);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String clickTwitterIcon() {
            String result = clickLocator(LO_LNK_ORANGEHRM_TWITTER, 0);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

        public String clickYoutubeIcon() {
            String result = clickLocator(LO_LNK_ORANGEHRM_YOUTUBE, 0);
            result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
            return result;
        }

    }

   

 

