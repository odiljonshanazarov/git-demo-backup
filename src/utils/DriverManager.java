package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverManager {

    private static WebDriver driver = null;

    public static void initialize() {
        //Use Of Singleton Concept and Initilize webDriver
        if (driver == null) {
            if (utils.ConstantVariable.browserName.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\chromedriver.exe");
                driver = new ChromeDriver();
            } else if (utils.ConstantVariable.browserName.equalsIgnoreCase("Firefox")) {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        driver.manage().deleteAllCookies();
    }
}
