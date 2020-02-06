import org.junit.Test;
import org.openqa.selenium.By;

public class UnfollowBot extends SeleniumTest {

    @Test
    public void loginTest() throws Exception {
        LoginPage loginPage = new LoginPage(driver);

        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[2]/p/a")).click();

        loginPage.isInitialized();

        loginPage.enterUsernameAndPassword("_jpot_", "Popolnikoncert090895");
        loginPage.submit();

        if (!loginPage.loginSuccessfull()) {
            driver.close();
            System.exit(1);
        }
    }

}
