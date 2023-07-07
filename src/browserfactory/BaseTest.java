package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;
    public void openBrowser(String baseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");

        //Launch the Chrome Browser
        driver = new ChromeDriver(options);

        //Open the URL into Browser
        driver.get(baseURL);

        //Maximise Browser
        driver.manage().window().maximize();

        //We give Implicit wait to Driver
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    // Close the Browser
    public void closeBrowser() {driver.quit();

    }}
