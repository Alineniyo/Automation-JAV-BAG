package framework.automation;

import java.time.Instant;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.mockito.Mockito;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;

import framework.utilities.FW_ConfigMgr;
import framework.utilities.FW_DebugUtils;
import framework.utilities.FW_PerformanceUtils;
//import framework.utilities.FW_ReportUtils;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.ElementNotInteractableException;

/**
 * This class provides a wrapper around WebDriver with additional utility
 * methods.
 */
public class FW_Driver {

    WebDriver driver;

    /**
     * Constructs a new FW_Driver with the specified WebDriver.
     *
     * @param driver the WebDriver to be used
     */
    public FW_Driver(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Returns the WebDriver instance that this FW_Driver is wrapping.
     *
     * @return the WebDriver instance
     */
    public WebDriver getDriver() {
        return this.driver;
    }

    /**
     * Quits this driver, closing every associated window.
     * 
     * @return True if successful driver quit operation, false otherwise.
     */
    public boolean quit() {
        try {
            driver.quit();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Get the locator elements
     * 
     * @param locator
     * 
     * @return The WebElement of the locator.
     */
    public WebElement getLocatorElement(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element;
        } catch (NoSuchElementException e) {
            return null;
        }
    }

    /**
     * Does the XPath locator exist on the page at this exact moment?
     *
     * @param locator The XPath locator to check for.
     * 
     * @return True if the locator exists, false otherwise.
     */
    public boolean locatorExist(String locator) {
        try {
            driver.findElement(By.xpath(locator));
            if ("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());}
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Checks if the XPath locator is displayed on the page.
     *
     * @param locator The XPath locator to check for.
     * 
     * @return True if the locator is displayed, false otherwise.
     */
    public boolean locatorDisplayed(String locator) {
        try {
            //var element = driver.findElement(By.xpath(locator));
            WebElement element = driver.findElement(By.xpath(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Highlights the locator on the page.
     *
     * @param locator The locator of the element to highlight.
     * @param css     The CSS to use for highlighting.
     */
    public void locatorHighlight(String locator, String css) {

        // For Debugging purposes
        //FW_DebugUtils.getCallerInfo(1);
        //FW_ReportUtils.printMessage("css:" + css + " locator:" + locator);
        
        try {
            WebElement element = driver.findElement(By.xpath(locator));

        // Check if element is not null and not a mock
        if (element != null && !Mockito.mockingDetails(element).isMock()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;

                // Convert CSS to lowercase
                css = css.toLowerCase();

                // Highlight the element
                js.executeScript(css, element);
            }
            } catch (NoSuchElementException e) {
        }
    }

    /**
     * Highlights the locator on the page using the configured options.
     *
     * @param locator The locator of the element to highlight.
     * @param startTime The time to use when determining the user satisfaction assessment.
     * @param overrideHighlight The highlighting state to use regardless of calculated user satisfaction. (Pass, WarnLow)
     */
    public void locatorHighlightHelper(String locator, Instant startTime, String overrideHighlight) {

        // Should locator have any highlighting done?
        if("true".equals(FW_ConfigMgr.getLocatorHighlight().toLowerCase())) {

            // Use override highlighting
            if(overrideHighlight != null && !overrideHighlight.isEmpty()) {
                // Clean up the overrideHighlight string
                overrideHighlight = overrideHighlight.toLowerCase().trim();

                // Use the overrideHighlight value to determine the highlighting color
                if("pass".equals(overrideHighlight)) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightPassCSS());
                } else if("warnlow".equals(overrideHighlight)) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightWarnLowCSS());
                } else if("warnmedium".equals(overrideHighlight)) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightWarnMediumCSS());
                } else if("warnhigh".equals(overrideHighlight)) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightWarnHighCSS());
                } else if("fail".equals(overrideHighlight)) {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightFailCSS());
                } else {
                    locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
                }

            // Use user satisfaction highlighting
            } else if ("true".equals(FW_ConfigMgr.getUserSatisfactionAssessment().toLowerCase())) {

                // Calculate user satisfaction assessment and highlight color
                Map<String, String> userSatisfactionAssessment = FW_PerformanceUtils.calcSatisfactionAssessment(startTime, Instant.now());
                locatorHighlight(locator,(userSatisfactionAssessment.get("assessColor")));
            
            // Use default highlighting
            } else {
                locatorHighlight(locator, FW_ConfigMgr.getLocatorHighlightCSS());
            }
        }
    }

    /**
     * Counts the number of matches for the XPath locator.
     *
     * @param locator The XPath locator to count.
     * 
     * @return The number of XPath locator matches.
     */
    public int countLocatorMatches(String locator) {
        if (locatorExist(locator)) {
            return driver.findElements(By.xpath(locator)).size();
        } else {
            return 0;
        }
    }

    /**
     * Checks if the number XPath matches is the same as the expected value.
     *
     * @param locator The XPath locator to count.
     * @param expectedCount The expected count to match.
     * 
     * @return True if the count is equal to the value, false otherwise.
     */
    public boolean checkLocatorMatchCount(String locator, int expectedMatchCount) {
        int elementCount = countLocatorMatches(locator);
        return elementCount == expectedMatchCount;
    }

    // Overload waitForDuration to provide default values for durationType and notify
    public static String waitForDuration(double waitDuration) {
        return waitForDuration(waitDuration, "s", false);
    }

    /**
     * Wait for a specified duration of time and allows interruption.
     * 
     * @param waitDuration The duration to wait with at least two decimal places.
     * @param durationType The duration type - (ms = milliseconds, s = seconds (default), m = minutes, h = hours)
     * @param notify If true, prints a message to the terminal about the usage of this method.
     * 
     * @return Details of where this was called from.
     */
    public static String waitForDuration(double waitDuration, String durationType, boolean notify) {

        // Handle null durationType by setting a default value
        if (durationType == null) {
            durationType = "s"; // default to seconds
        }

        // Set default value
        long milliseconds = 0;

        switch (durationType.trim().toLowerCase()) {
            case "ms":
            case "milliseconds":
                milliseconds = (long) (waitDuration);
                break;
            case "s":
            case "seconds":
                milliseconds =  (long) (waitDuration * 1000);
                break;
            case "m":
            case "minutes":
                milliseconds =  (long) (waitDuration * 1000 * 60);
                break;
            case "h":
            case "hours":
                milliseconds =  (long) (waitDuration * 1000 * 60 * 60);
                break;
            default:
                milliseconds =  (long) (waitDuration * 1000); // Default to seconds
                break;
        }

        // Prepare the caller information
        String callerInfo = "waitForDuration called";
        callerInfo = callerInfo + " - " + FW_DebugUtils.getCallerInfo(0, false);
        
        // Print the caller information if notify is true
        if (notify == true) {
            System.out.println(callerInfo);
        }
        
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            System.out.println("Wait was interrupted.");
            return callerInfo + " - Wait interrupted.";
        }
        
        return callerInfo;
    }
    
    /**
     * Wait for the XPath locator to exist on the page.
     *
     * @param locator  The XPath locator to check for.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return True if the locator exists, false otherwise.
     */
    public boolean waitToExist(String locator, int timeout, int interval) {
        var startingTime = Instant.now().getEpochSecond();
        var timeoutReached = false;

        while (!timeoutReached) {
            if (locatorDisplayed(locator)) {
                return true;
            }
            timeoutReached = Instant.now().getEpochSecond() - startingTime >= timeout;
            waitForDuration(interval, "s", false); // Wait to perform next check
        }
        return false;
    }

    /**
     * Wait for the XPath locator to not exist on the page.
     *
     * @param locator  The XPath locator to check for not existance.
     * @param timeout  The number of seconds to wait before timing out.
     * @param interval The number of seconds to wait between checks.
     * 
     * @return True if the locator exists, false otherwise.
     */
    public boolean waitToNotExist(String locator, int timeout, int interval) {
        var startingTime = Instant.now().getEpochSecond();
        var timeoutReached = false;

        while (!timeoutReached) {
            if (!locatorDisplayed(locator)) {
                return true;
            }
            timeoutReached = Instant.now().getEpochSecond() - startingTime >= timeout;
            waitForDuration(interval, "s", false); // Wait to perform next check
        }
        return false;
    }

    /**
     * Checks if an alert exists.
     *
     * @return true if an alert exists, false otherwise.
     */
    public boolean alertExist() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    /**
     * Waits for alert to exist, checking at intervals for timeout.
     *
     * @param timeout The maximum time to wait in seconds.
     * @param interval The interval at which to check in seconds.
     * 
     * @return true if an alert exists within the timeout, false otherwise.
     */
    public boolean waitForAlertToExist(int timeout, int interval) {
        long startTime = System.currentTimeMillis();
        boolean timeoutReached = false;

        while (!timeoutReached) {
            if (alertExist()) {
                return true;
            }

            timeoutReached = System.currentTimeMillis() - startTime >= TimeUnit.SECONDS.toMillis(timeout);
            
            waitForDuration(interval, "s", false); // Wait to perform next check
        }
        return false;
    }

    /**
     * Waits for alert to not exist, checking at intervals for timeout.
     *
     * @param timeout The maximum time to wait in seconds.
     * @param interval The interval at which to check in seconds.
     * 
     * @return true if an alert does not exist within the timeout, false otherwise.
     */
    public boolean waitForAlertToNotExist(int timeout, int interval) {
        long startTime = System.currentTimeMillis();
        boolean timeoutReached = false;

        while (!timeoutReached) {
            if (!alertExist()) {
                return true;
            }

            timeoutReached = System.currentTimeMillis() - startTime >= TimeUnit.SECONDS.toMillis(timeout);
            
            waitForDuration(interval, "s", false); // Wait to perform next check
        }
        return false;
    }

    /**
     * Checks if an alert is interactable.
     *
     * @return true if an alert is interactable, false otherwise.
     */
    public boolean alertInteractable() {
        if (!alertExist()) {
            return false;
        }
        try {
            driver.switchTo().alert().sendKeys("Interactable Check");
            return true;
        } catch (ElementNotInteractableException e) {
            return false;
        }
    }

    /**
     * Select accept on alert.
     *
     * @return true if accept on alert was successfully otherwise false.
     */
    public boolean alertAccept() {
        if (!alertExist()) {
            return false;
        }
        try {
            driver.switchTo().alert().accept();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Select dismiss on alert.
     *
     * @return true if dismiss on alert was successfully otherwise false.
     */
    public boolean alertDismiss() {
        if (!alertExist()) {
            return false;
        }
        try {
            driver.switchTo().alert().dismiss();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Gets the text of an alert if it exists.
     *
     * @return The text of the alert, or an empty string if no alert exists.
     */
    public String alertText() {
        if (!alertExist()) {
            return "";
        }
        return driver.switchTo().alert().getText();
    }

    /**
     * Executes the JavaScript against the given locator.
     *
     * @param javascript Javascript to be executed.
     * @param locator The XPath locator to perform the javascript against.
     * 
     * @return boolean indicating success or failure of script execution.
     */
    public boolean executeJavascript(String javascript, String locator) {
        try {
            if (locator != null) {
                WebElement element = driver.findElement(By.xpath(locator));
                ((JavascriptExecutor) driver).executeScript(javascript, element);
            } else {
                ((JavascriptExecutor) driver).executeScript(javascript);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Types a key on the keyboard.
     *
     * @param key The key to type.
     * 
     * @return True if the key was typed, false otherwise.
     */
    public boolean typeOnKeyboard(String key) {
        Actions actions = new Actions(driver);
        boolean result = true;

        switch (key.toUpperCase()) {
            case "TAB":
                actions.sendKeys(Keys.TAB).perform();
                break;
            case "ENTER":
                actions.sendKeys(Keys.ENTER).perform();
                break;
            case "ESCAPE":
                actions.sendKeys(Keys.ESCAPE).perform();
                break;
            case "ARROW_UP":
                actions.sendKeys(Keys.ARROW_UP).perform();
                break;
            case "ARROW_DOWN":
                actions.sendKeys(Keys.ARROW_DOWN).perform();
                break;
            // Add more cases as needed
            default:
                System.out.println("Invalid key: " + key);
                result = false;
                break;
        }

        return result;
    }

    /**
     * Scrolls the locator into view.
     *
     * @param locator The XPath locator to check for.
     * 
     * @return True if the locator is in view, false otherwise.
     */
    public boolean scrollTo(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            Actions actions = new Actions(driver);
            actions.moveToElement(element).perform();
            return true;
        } catch (NoSuchElementException e) {
            System.out.println("[Fail Details] - Element with locator: '" + locator + "' does not exist.");
            return false;
        } catch (Exception e) {
            System.out.println("[Fail Details] - Error scrolling to locator: '" + locator + "' " + e);
            return false;
        }
    }

    /**
     * Sets the scroll-behavior to auto within the HTML.
     * 
     * @return True if scroll-behavior executed successfully, false otherwise.
     */
    public boolean disableSmoothScroll() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("document.querySelector('html').style = 'scroll-behavior: auto;';");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Returns the value of the given attribute from the matched locator.
     *
     * @param locator   The locator to check for.
     * @param attribute The attribute to get the value of.
     * 
     * @return A string containing the value of the attribute, or an empty string if
     *         the locator does not exist.
     */
    public String valueFromLocatorAttribute(String locator, String attribute) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.getAttribute(attribute);
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Returns text of element (typically found between opening and closing tags).
     *
     * @param locator The locator to check for.
     * 
     * @return A string containing the text of the element, or an empty string if the locator does not exist.
     */
    public String textFromLocator(String locator) {
        try {
            WebElement element = driver.findElement(By.xpath(locator));
            return element.getText();
        } catch (NoSuchElementException e) {
            return "";
        }
    }

    /**
     * Loads a URL in the driver.
     *
     * @param url The URL to load.
     * 
     * @return True if the URL was loaded successfully, false otherwise.
     */
    public boolean loadUrl(String url) {
        if (url == null || url.isEmpty()) {
            System.out.println("[Fail Details] - Provided URL: '" + url + "' is null or empty.");
            return false;
        }

        try {
            driver.get(url);
            return true;
        } catch (Exception e) {
            if (e.getMessage().contains("ERR_NAME_NOT_RESOLVED")) {
                System.out.println("[Fail Details] - Could not resolve URL: '" + url + "' to a valid IP address.");
            } else {
                System.out.println("[Fail Details] - An unexpected error occurred: " + e.getMessage());
            }
            return false;
        }
    }

    /**
     * Gets the URL of the current page.
     *
     * @return The URL of the current page.
     */
    public String url() {
        return driver.getCurrentUrl();
    }

    /**
     * Gets the HTML served source of the current page.
     *
     * @return The HTML served source of the current page.
     */
    public String htmlServedSource() {
        return driver.getPageSource();
    }

    /**
     * Gets the HTML rendered source of the current page.
     *
     * @return The HTML rendered source of the current page.
     */
    public String htmlRenderedSource() {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        return (String) jsExec.executeScript("return document.documentElement.outerHTML;");
    }

}