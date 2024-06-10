package pageobjects;

import org.openqa.selenium.WebDriver;
import framework.automation.FW_Page;

public class PO_Results extends FW_Page {

    private static final String LO_IMG_GOOGLE = "//div[@id='searchform']//div[contains(@class,'logo')]";

    public PO_Results(WebDriver driver) {
        super(driver);
    }

    public String validateOnPage(){
        return validateLocatorExists(LO_IMG_GOOGLE, 10, 1);
    }

}