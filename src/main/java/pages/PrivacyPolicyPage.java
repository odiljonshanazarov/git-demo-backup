package task2_1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Calendar;

public class PrivacyPolicyPage {

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/english.gif']")
    public WebElement iconEnglishLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/spanish.gif']")
    public WebElement iconSpanishLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/french.gif']")
    public WebElement iconFrenchLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/german.gif']")
    public WebElement iconGermanLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/italian.gif']")
    public WebElement iconItalianLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/russian.gif']")
    public WebElement iconRussianLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/japanese.gif']")
    public WebElement iconJapaneseLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/portuguese.gif']")
    public WebElement iconPortugueseLanguage;

    @FindBy(xpath = ".//img[@src='https://store.cloudflare.steamstatic.com/public/images/languageflags/brazilian.gif']")
    public WebElement iconBrazilianLanguage;

    @FindBy(xpath = ".//i[starts-with(text(), 'Revision Date:')]")
    public WebElement txtPolicyRevisionFullDate;

    public String getCurrentRevisionYear() {
        String fullDate = txtPolicyRevisionFullDate.getText();
        String currentRevisionYear = fullDate.substring(fullDate.length() - 4);
        return currentRevisionYear;
    }

    public String getCurrentActualYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        String currentActualYear = String.valueOf(currentYear);
        return currentActualYear;
    }


}
