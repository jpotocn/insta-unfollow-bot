import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpotocn\\IdeaProjects\\InstaUnfollower\\src\\webDriver\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.google.si");
        driver.close();
    }

}
