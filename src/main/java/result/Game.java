package task2_1.result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.Objects;

public class Game {

    private String gameName;
    private String gameReleaseDate;
    private String gamePrice;

    public Game(String gameName, String gameReleaseDate, String gamePrice) {
        this.gameName = gameName;
        this.gameReleaseDate = gameReleaseDate;
        this.gamePrice = gamePrice;
    }

    public static Game fromSearchResultRow(WebElement element) {
        return new Game(
                element.findElement(By.className("title")).getText(),
                element.findElement(By.className("search_released")).getText(),
                element.findElement(By.className("search_price")).getText()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(gameName, game.gameName) &&
                Objects.equals(gameReleaseDate, game.gameReleaseDate) &&
                Objects.equals(gamePrice, game.gamePrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameName, gameReleaseDate, gamePrice);
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getGameReleaseDate() {
        return gameReleaseDate;
    }

    public void setGameReleaseDate(String gameReleaseDate) {
        this.gameReleaseDate = gameReleaseDate;
    }

    public String getGamePrice() {
        return gamePrice;
    }

    public void setGamePrice(String gamePrice) {
        this.gamePrice = gamePrice;
    }
}
