package framework.utilities;

/**
 * This class provides utility methods for system needs.
 */
public class FW_SystemUtils {

    /**
     * This method returns the current directory path.
     * 
     * @return The current directory path.
     */
    public static String presentDirectoryPath() {
        String result = System.getProperty("user.dir");
        return result;
    }

    /**
     * This method checks if a path landmark exists in the given path.
     *
     * @param path The path to evaluate (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * @param landmark The landmark in the path to find (e.g. "Automation-Projects").
     * 
     * @return True if the landmark exists in the given path, false otherwise.
     */
    public static boolean pathLandmarkExist(String path, String landmark) {
        if (path != null && !path.isEmpty() && landmark != null && !landmark.isEmpty()) {
            int pathLandmarkLocation = path.indexOf(landmark);
            if (pathLandmarkLocation != -1) {
                return true; // Landmark exists in the path
            } else {
                return false; // Landmark does not exist in the path
            }
        } else {
            return false; // Path or landmark is null or empty
        }
    }

    /**
     * This method returns the directory path up to the landmark.
     *
     * @param path The path to evaluate (e.g. "/Users/user.name/Automation-Projects/Automation-JAV-Sandbox").
     * @param landmark The landmark in the path to find (e.g. "Automation-Projects").
     * @param includeLandmark Whether to include the landmark in the returned path.
     * 
     * @return The directory path up to the landmark, or an empty string if the landmark does not exist in the path.
     */
    public static String getLandmarkDirectoryPath(String path, String landmark, boolean includeLandmark) {
        if (path != null && !path.isEmpty() && landmark != null && !landmark.isEmpty()) {
            int pathLandmarkLocation = path.indexOf(landmark);
            if (pathLandmarkLocation != -1) {
                if (includeLandmark) {
                    return path.substring(0, pathLandmarkLocation + landmark.length());
                } else {
                    return path.substring(0, pathLandmarkLocation);
                }
            }
        }
        return "";
    }
}
