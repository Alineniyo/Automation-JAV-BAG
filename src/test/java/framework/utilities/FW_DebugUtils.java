package framework.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Utility class for debugging
 */
public class FW_DebugUtils {

    // Declare ANSI escape sequences for formatting console output colors
    static String black =       "\033[0;30m";            // BLACK
    static String brown =       "\033[38;5;94m";         // BROWN
    static String red =         "\033[38;2;255;0;0m";    // RED
    static String pink =        "\033[38;2;255;193;203m";// PINK
    static String coral =       "\033[38;2;255;127;80m"; // CORAL
    static String orange =      "\033[38;2;255;165;0m";  // ORANGE
    static String yellow =      "\033[38;2;255;255;0m";  // YELLOW
    static String green =       "\033[38;2;0;128;1m";    // GREEN
    static String greenyellow = "\033[38;2;173;255;47m"; // GREEN YELLOW
    static String blue =        "\033[0;34m";            // BLUE
    static String violet =      "\033[0;35m";            // VIOLET
    static String grey =        "\033[0;37m";            // GREY
    static String darkGrey =    "\033[0;90m";            // DARK GREY
    static String white =       "\033[0;97m";            // WHITE
    static String reset =       "\033[0m";               // Text Reset

    /**
     * Logs information about the caller method, including thread details and class name.
     *
     * @param verbosityLevel The level of beautification:
     *                       - 0: Simple output (single line)
     *                       - 1: Decorated output (border above and below)
     *                       - 2: Detailed output with timestamp (multiple lines)
     * @param notify If true (default), prints a message to the terminal about the usage of this method. False only pass back the caller information.
     * 
     * @return Caller Information
     */
    public static String getCallerInfo(int verbosityLevel, boolean notify) {

        // Get timestamp
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a"));

        // Get Thread details
        Thread currentThread = Thread.currentThread();
        String threadName = currentThread.getName();
        long threadId = currentThread.threadId();

        // Get the called from method details
        StackTraceElement caller2 = Thread.currentThread().getStackTrace()[2];
        String methodName2 = caller2.getMethodName();
        String className2 = caller2.getClassName().replace("framework.automation.", "");
        className2 = className2.replace("pageobjects.", "");
        int lineNumber2 = caller2.getLineNumber();

        // Get the caller method details
        StackTraceElement caller3 = Thread.currentThread().getStackTrace()[3];
        String methodName3 = caller3.getMethodName();
        String className3 = caller3.getClassName().replace("framework.automation.", "");
        className3 = className3.replace("pageobjects.", "");
        int lineNumber3 = caller3.getLineNumber();

        // Get the caller method details
        StackTraceElement caller4 = Thread.currentThread().getStackTrace()[4];
        String methodName4 = caller4.getMethodName();
        String className4 = caller4.getClassName().replace("framework.automation.", "");
        className4 = className4.replace("pageobjects.", "");
        int lineNumber4 = caller4.getLineNumber();

        String combString = "";
        String callerInfo = "";

        switch (verbosityLevel) {
            case 0:
                combString = "Thread:" + threadName + "(" + threadId + ") - " + className4 + "." + methodName4 + ":" + lineNumber4 + " ⇄ " + className3 + "." + methodName3 + ":" + lineNumber3 + " ⇄ " + className2 + "." + methodName2 + ":" + lineNumber2;
                callerInfo = violet + combString + reset;
                break;
            case 1:
                combString = "Thread:" + threadName + "(" + threadId + ") - " + className4 + "." + methodName4 + ":" + lineNumber4 + " ⇄ " + className3 + "." + methodName3 + ":" + lineNumber3 + " ⇄ " + className2 + "." + methodName2 + ":" + lineNumber2;
                combString = FW_StringUtils.formatWithBorder(combString);
                callerInfo = violet + combString + reset;
                break;
            case 2:
                combString  = "Time: " + timestamp + "\n";
                combString += "Thread: " + threadName + "\n";
                combString += "Thread ID: " + threadId + "\n";
                combString += "Methdod called to:\n";
                combString += "   Class: " + className4 + "\n";
                combString += "   Method: " + methodName4 + "()\n";
                combString += "   Line number: " + lineNumber4 + "\n";
                combString += "Method called from:\n";
                combString += "   Class: " + className3 + "\n";
                combString += "   Method: " + methodName3 + "()\n";
                combString += "   Line number: " + lineNumber3;
                combString += "Methdod called from:\n";
                combString += "   Class: " + className2 + "\n";
                combString += "   Method: " + methodName2 + "()\n";
                combString += "   Line number: " + lineNumber2 + "\n";
                combString = FW_StringUtils.formatWithBorder(combString);
                callerInfo = violet + combString + reset;
                break;
            default:
                callerInfo = "Invalid verbosity level. Use 0, 1, or 2.";
                break;
        }

        // Print the caller information if notify is true
        if (notify == true) {
            System.out.println(callerInfo);
        }

        return callerInfo; // Return the caller information
    }

    // Overload getCallerInfo to provide default values for verbosityLevel and notify
    public static String getCallerInfo() {
        return getCallerInfo(0, true);
    }

    /**
     * Returns the name of the method that called this method.
     *
     */
    public static void getMethodName() {
        StackTraceElement caller = Thread.currentThread().getStackTrace()[3];
        String methodName = caller.getMethodName();
        String className = caller.getClassName();
        System.out.println("Method: " + className + "." + methodName);
    }

}
