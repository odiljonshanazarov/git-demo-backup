package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected static WebDriver driver;

    //should open a page
    public abstract void open();

    public static void setDriver(WebDriver driver) {
        BasePage.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }


}
