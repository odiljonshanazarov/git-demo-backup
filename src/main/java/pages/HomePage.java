package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {


    @Override
    public void open() {
        driver.get("https://store.steampowered.com");
    }

    @FindBy(xpath = ".//a[@class='pulldown_desktop' and text()='Your Store']")
    public WebElement lnkYourStore;

    @FindBy(xpath = ".//a[@class='global_action_link' and text()='login']")
    public WebElement btnLogin;

    @FindBy(xpath = ".//a[@href='https://store.steampowered.com/privacy_agreement/?snr=1_44_44_' and text()='Privacy Policy']")
    public WebElement lnkPrivacyPolicy;

    @FindBy(css = "input#store_nav_search_term")
    public WebElement txtboxSearch;

    @FindBy(xpath = "(.//img[@src='https://store.cloudflare.steamstatic.com/public/images/blank.gif'])[1]")
    public WebElement btnSearch;


    public void clickSearchBtn() {
        btnSearch.click();
    }


}
