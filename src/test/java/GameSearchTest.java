import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import result.JsonSerializer;

import pages.ResultPage;
import result.Game;

import java.io.IOException;
import java.net.URISyntaxException;


import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class GameSearchTest {

    @Test
    public void test() throws IOException, URISyntaxException {
        BasePage.setDriver(new ChromeDriver());
        HomePage homePage = new HomePage();
        homePage.open();

        Dimension newDimension = new Dimension(1440, 850);
        BasePage.getDriver().manage().window().setSize(newDimension);
        BasePage.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        PageFactory.initElements(BasePage.getDriver(), homePage);

        String textToSearch = "Dota 2";
        homePage.txtboxSearch.sendKeys(textToSearch);
        homePage.clickSearchBtn();

        ResultPage resultPage = new ResultPage();
        PageFactory.initElements(BasePage.getDriver(), resultPage);

        Set<Game> games = resultPage.getSearchResultRows().stream().limit(2).map(r -> Game.fromSearchResultRow(r)).collect(Collectors.toSet());

        Assert.assertEquals(resultPage.txtboxSearchWithSearchedText.getAttribute("value"), textToSearch, "Searched text don't match");
        Assert.assertEquals(resultPage.txtFirstGameName.getText(), textToSearch, "First game name don't match");

        JsonSerializer jsonSerializer = new JsonSerializer();
        jsonSerializer.writeToJson(games);

        homePage.txtboxSearch.sendKeys(resultPage.txtSecondGameName.getText());
        homePage.clickSearchBtn();

        resultPage = new ResultPage();
        PageFactory.initElements(BasePage.getDriver(), resultPage);

        Set<Game> games2 = resultPage.getSearchResultRows().stream().limit(2).map(r -> Game.fromSearchResultRow(r)).collect(Collectors.toSet());

        Assert.assertTrue(games.containsAll(games2), "Two search results don't match");

    }
}
