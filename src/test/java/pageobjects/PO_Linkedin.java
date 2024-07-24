package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Linkedin extends FW_Page {

private static final String LO_LNK_NAV_Linkedin_VALIDATE = "//icon[@class='block text-color-brand w-[102px] h-[26px] lazy-loaded']";
private static final String LO_LNK_NAV_Linkedin_CLOSE_BUTTON_ = "//button[@aria-label='Dismiss']";


    public PO_Linkedin(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_NAV_Linkedin_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }

    public String clickCloseButton() {
        String result = clickLocator(LO_LNK_NAV_Linkedin_CLOSE_BUTTON_, 0);
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
    return result;
    }


}


