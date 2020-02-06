import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class InitUtils {

    public static final String BROWSER_CHROME = "chrome";
    public static final String BROWSER_FIREFOX = "firefox";
    public static final String BROWSER_IE = "ie";
    public static final String BROWSER_EDGE = "edge";

    private static final String CHROME_DRIVER_PATH = "C:\\Users\\jpotocn\\IdeaProjects\\InstaUnfollower\\src\\webDriver\\chromedriver.exe";
    private static final String IE_DRIVER_PATH = "C:/Selenium/Libraries/IEDriverServer_32bit.exe";
    private static final String GECKO_DRIVER_PATH = "C:/Selenium/Libraries/geckodriver.exe"; // Firefox version must be >= 47


    /**
     * Init WebDriver to use during entire testing procedure.
     *
     * @param isRemote if true, selenium server is used
     * @param browserToUse "firefox", "ie" or "edge". Others for Chrome.
     * @return
     */
    public static WebDriver initDriver(boolean isRemote, String browserToUse) {

        WebDriver driver = null;

        if (isRemote) {
            DesiredCapabilities desiredCaps;
            if (browserToUse.equals(BROWSER_FIREFOX))
                desiredCaps = DesiredCapabilities.firefox();
            else if (browserToUse.equals(BROWSER_IE))
                desiredCaps = DesiredCapabilities.internetExplorer();
            else if (browserToUse.equals(BROWSER_EDGE))
                desiredCaps = DesiredCapabilities.edge();
            else
                desiredCaps = DesiredCapabilities.chrome();

        } else {
            System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
            System.setProperty("webdriver.ie.driver", IE_DRIVER_PATH);
            System.setProperty("webdriver.gecko.driver", GECKO_DRIVER_PATH);

            if (browserToUse.equals(BROWSER_IE))
                driver = new InternetExplorerDriver();
            else if (browserToUse.equals(BROWSER_FIREFOX)) {
                DesiredCapabilities cap = DesiredCapabilities.firefox();
                cap.setCapability("marionette", true);
                driver = new FirefoxDriver(cap);
            }
            else {
                driver = new ChromeDriver();
            }
        }

        return driver;
    }

}
