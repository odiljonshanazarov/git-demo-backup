package task2_1;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import task2_1.pages.HomePage;
import task2_1.pages.BasePage;
import task2_1.pages.PrivacyPolicyPage;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrivacyPolicyTest {

    @Test
    public void test() throws InterruptedException {

        BasePage.setDriver(new ChromeDriver());
        HomePage homePage = new HomePage();
        homePage.open();
        Dimension newDimension = new Dimension(1440, 850);
        BasePage.getDriver().manage().window().setSize(newDimension);
        BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(BasePage.getDriver(), homePage);

        homePage.lnkPrivacyPolicy.click();

        List<String> browserTabs = new ArrayList<String>(BasePage.getDriver().getWindowHandles());
        BasePage.getDriver().switchTo().window(browserTabs.get(1));

        PrivacyPolicyPage privacyPolicyPage = new PrivacyPolicyPage();
        PageFactory.initElements(BasePage.getDriver(), privacyPolicyPage);

        Assert.assertTrue(privacyPolicyPage.iconEnglishLanguage.isDisplayed(), "English Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconSpanishLanguage.isDisplayed(), "Spanish Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconFrenchLanguage.isDisplayed(), "French Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconGermanLanguage.isDisplayed(), "German Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconItalianLanguage.isDisplayed(), "Italian Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconRussianLanguage.isDisplayed(), "Russian Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconJapaneseLanguage.isDisplayed(), "Japanese Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconPortugueseLanguage.isDisplayed(), "Portuguese Language icon is not displayed");
        Assert.assertTrue(privacyPolicyPage.iconBrazilianLanguage.isDisplayed(), "Brazilian Language icon is not displayed");

        Assert.assertEquals(privacyPolicyPage.getCurrentRevisionYear(), privacyPolicyPage.getCurrentActualYear());

    }
}
