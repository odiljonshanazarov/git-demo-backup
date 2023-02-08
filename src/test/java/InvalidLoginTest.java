

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import task2_1.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class InvalidLoginTest extends BaseTest {

    @Test
    public void test() throws InterruptedException {

        BasePage.setDriver(new ChromeDriver());
        HomePage homePage = new HomePage();
        homePage.open();
        Dimension newDimension = new Dimension(1440, 850);
        BasePage.getDriver().manage().window().setSize(newDimension);
        BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(BasePage.getDriver(), homePage);

        Assert.assertTrue(homePage.lnkYourStore.isDisplayed(), "Your Store link is not displayed");
        Reporter.log("Your Store link is displayed");

        homePage.btnLogin.click();

        LoginPage loginPage = new LoginPage();
        PageFactory.initElements(BasePage.getDriver(), loginPage);

        Assert.assertTrue(loginPage.txtSignInWithAccountName.isDisplayed(), "Sign In With Account Name text is not displayed");
        Reporter.log("Sign In With Account Name text is displayed");

        loginPage.txtBoxSignIn.sendKeys(generatedString());
        loginPage.txtBoxPassword.sendKeys(generatedString());
        loginPage.btnSignIn.click();

        Assert.assertTrue(loginPage.btnSignInLoading.isDisplayed(), "Sign In button loading element is not displayed");
        Reporter.log("Sign In button loading element is displayed");

        Assert.assertTrue(loginPage.txtErrorSignInText.isDisplayed(), "Sign In Error text is not displayed");
        Reporter.log("Sign In Error text is displayed");

    }
}
