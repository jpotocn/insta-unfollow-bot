import com.google.common.base.MoreObjects;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class SeleniumTest {

    protected static WebDriver driver;

    private static final String INSTAGRAM_URL = "https://www.instagram.com";
    private static final boolean IS_REMOTE = Boolean.valueOf(System.getProperty("REMOTE"));
    private static final String BROWSER_TO_USE = MoreObjects.firstNonNull(System.getProperty("BROWSER"), InitUtils.BROWSER_CHROME);

    @BeforeClass
    public static void setUp(){
        driver = InitUtils.initDriver(IS_REMOTE, BROWSER_TO_USE);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(INSTAGRAM_URL);
    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
