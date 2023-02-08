package task2_1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy(xpath = ".//*[text()='Sign in with account name']")
    public WebElement txtSignInWithAccountName;

    @FindBy(xpath = ".//*[@type='text' and @class='newlogindialog_TextInput_2eKVn']")
    public WebElement txtBoxSignIn;

    @FindBy(xpath = ".//*[@type='password' and @class='newlogindialog_TextInput_2eKVn']")
    public WebElement txtBoxPassword;

    @FindBy(xpath = ".//button[@class='newlogindialog_SubmitButton_2QgFE' and text()='Sign in']")
    public WebElement btnSignIn;

    @FindBy(xpath = ".//div[@class='newlogindialog_LoadingContainer_OYHj3']")
    public WebElement btnSignInLoading;

    @FindBy(xpath = ".//div[@class='newlogindialog_FormError_1Mcy9']")
    public WebElement txtErrorSignInText;


}
