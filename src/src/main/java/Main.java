import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\jpotocn\\IdeaProjects\\InstaUnfollower\\src\\webDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.navigate().to("https://www.instagram.com");

        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/article/div[2]/div[2]/p/a")).click();

        driver.findElement(By.name("username")).sendKeys("_jpot_");
        driver.findElement(By.name("password")).sendKeys("Popolnikoncert090895");
        driver.findElement(By.xpath("//*[@id=\"react-root\"]/section/main/div/article/div/div[1]/div/form/div[4]/button")).click();
        driver.close();
    }

}
