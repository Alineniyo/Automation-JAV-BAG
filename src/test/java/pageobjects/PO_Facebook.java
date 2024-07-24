package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Facebook extends FW_Page {

private static final String LO_LNK_NAV_FACEBOOK_VALIDATE = "//div[@class='x1xka2u1 xqfms19']//span[contains(text(),'See more on Facebook')]";


    public PO_Facebook(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_NAV_FACEBOOK_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


}


