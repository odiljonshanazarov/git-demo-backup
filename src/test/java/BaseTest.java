
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import java.util.Random;


public abstract class BaseTest {

    @BeforeSuite
    public void setup() {
        //DriverManager dr = new DriverManager()
    }

    @AfterSuite
    public void closeBrowser() {
        ChromeOptions chromeOptions= new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromeOptions);
        driver.quit();
    }

    public String generatedString(){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        String generatedString = buffer.toString();

       return generatedString;
    }
}
