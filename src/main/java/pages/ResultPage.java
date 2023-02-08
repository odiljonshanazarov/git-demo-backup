package task2_1.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage {

    @FindBy(xpath = ".//a[contains(@class, 'search_result_row')][position() < 3]")
    private List<WebElement> searchResultRows;

    public List<WebElement> getSearchResultRows() {
        return searchResultRows;
    }

    @FindBy(css = "input[id=term][name=displayterm]")
    public WebElement txtboxSearchWithSearchedText;

    @FindBy(xpath = "(.//span[@class='title'])[1]")
    public WebElement txtFirstGameName;


    @FindBy(xpath = "(.//span[@class='title'])[2]")
    public WebElement txtSecondGameName;


}
