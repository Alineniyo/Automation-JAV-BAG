package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;
import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_StringUtils;

public class PO_Youtube extends FW_Page {

private static final String LO_LNK_NAV_SOCIALMEDIA_YOUTUBE_VALIDATE = "//div[@class='page-header-view-model-wiz__page-header-headline-info']//h1[@class='dynamic-text-view-model-wiz__h1']";


    public PO_Youtube(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        String result = validateLocatorExists(LO_LNK_NAV_SOCIALMEDIA_YOUTUBE_VALIDATE, FW_ConfigMgr.getDefaultTimeout(), FW_ConfigMgr.getDefaultInterval());
        result = FW_StringUtils.metaInsert(result, getClass().getSimpleName()); // Insert PO name into results
        return result;
    }


}


