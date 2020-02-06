import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    private final WebDriver driver;

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(xpath = "//*[@id=\"react-root\"]/section/main/div/article/div/div[1]/div/form/div[4]/button")
    private WebElement loginButton;


    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isInitialized() {
        return username.isDisplayed();
    }


    public void enterUsernameAndPassword(String username, String password) {
//        this.username.clear();
        this.username.sendKeys(username);

        this.password.clear();
        this.password.sendKeys(password);
    }

    public LoginPage submit() {
        loginButton.click();
        return new LoginPage(driver);
    }

    public boolean loginSuccessfull() {
        return ! driver.getCurrentUrl().contains("login.xhtml");
    }
}

