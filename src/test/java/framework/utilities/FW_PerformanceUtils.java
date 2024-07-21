package framework.utilities;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * This class provides utility methods related to performance.
 */
public class FW_PerformanceUtils {

    /**
     * Calculate typical customer satisfaction assessment based on the elapsed time.
     *
     * @param startTime The start time.
     * @param finishTime The finish time.
     * 
     * @return A map containing the results of the satisfaction assessment.
     * 
     */
    public static Map<String, String> calcSatisfactionAssessment(Instant startTime, Instant finishTime) {
        Map<String, String> results = new HashMap<>();
        Duration duration = Duration.between(startTime, finishTime);
        double elapsedTime = duration.toMillis() / 1000.0; // Changed to double
        
        String assessResult;
        String assessColor;
        if (elapsedTime <= 2.0) {
            assessResult = "[Pass]";
            assessColor = FW_ConfigMgr.getLocatorHighlightPassCSS();
        } else if (elapsedTime <= 3.0) {
            assessResult = "[Pass Warn - Low]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnLowCSS();
        } else if (elapsedTime <= 5.0) {
            assessResult = "[Pass Warn - Medium]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnMediumCSS();
        } else if (elapsedTime <= 10.0) {
            assessResult = "[Pass Warn - High]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnHighCSS();
        } else {
            assessResult = "[Pass Warn - Critical]";
            assessColor = FW_ConfigMgr.getLocatorHighlightWarnCriticalCSS();
        }

        results.put("elapsedTime", String.valueOf(elapsedTime));
        results.put("assessResult", assessResult);
        results.put("assessColor", assessColor);

        return results;
    }


}