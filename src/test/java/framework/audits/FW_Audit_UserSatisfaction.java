package framework.audits;

// Import class packages for this Audit Object (AO)
//import java.time.Instant;
//import java.util.Map;

//import framework.automation.FW_Driver;
//import framework.automation.FW_Network;
//import framework.utilities.FW_ConfigMgr;
//import framework.utilities.FW_PerformanceUtils;

/**
 * This class performs an audit of the typical user satisfaction.
 */
public class FW_Audit_UserSatisfaction {

    // /**
    //  * Highlights the locator on the page using the configured options.
    //  *
    //  * @param locator The locator of the element to highlight.
    //  * @param startTime The time to use when determining the user satisfaction assessment.
    //  */
    // public void locatorHighlightHelper(String locator, Instant startTime) {

    //     FW_Driver fwDriver = new FW_Driver(); // Instantiate the FW_Driver class

    //     // Should locator have any highlighting done?
    //     if("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {

    //         // Use user satisfaction highlighting
    //         if("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {

    //             // Calculate user satisfaction assessment and highlight color
    //             Map<String, String> userSatisfactionAssessment = FW_PerformanceUtils.calcSatisfactionAssessment(startTime, Instant.now());
    //             fwDriver.locatorHighlight(locator,(userSatisfactionAssessment.get("assessColor")));

    //         // Use default highlighting
    //         } else {
    //             fwDriver.locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
    //         }
    //     }
    // }
    
}
