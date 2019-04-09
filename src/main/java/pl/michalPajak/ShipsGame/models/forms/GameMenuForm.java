package pl.michalPajak.ShipsGame.models.forms;

import pl.michalPajak.ShipsGame.models.enums.GameMode;

import java.util.Objects;

public class GameMenuForm {
    private GameMode gameMode;
    private String firstPlayerName;
    private String secondPlayerName;
    private int numberOfFieldsHorizontally;
    private int numberOfFieldsVertically;

    public GameMenuForm() {
        this.gameMode = GameMode.PLAYERTOCOMPUTER;
        this.firstPlayerName = "Player1";
        this.secondPlayerName = "Player2";
        this.numberOfFieldsHorizontally = 0;
        this.numberOfFieldsVertically = 0;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public int getNumberOfFieldsHorizontally() {
        return numberOfFieldsHorizontally;
    }

    public void setNumberOfFieldsHorizontally(int numberOfFieldsHorizontally) {
        this.numberOfFieldsHorizontally = numberOfFieldsHorizontally;
    }

    public int getNumberOfFieldsVertically() {
        return numberOfFieldsVertically;
    }

    public void setNumberOfFieldsVertically(int numberOfFieldsVertically) {
        this.numberOfFieldsVertically = numberOfFieldsVertically;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameMenuForm)) return false;
        GameMenuForm that = (GameMenuForm) o;
        return getNumberOfFieldsHorizontally() == that.getNumberOfFieldsHorizontally() &&
                getNumberOfFieldsVertically() == that.getNumberOfFieldsVertically() &&
                getGameMode() == that.getGameMode() &&
                getFirstPlayerName().equals(that.getFirstPlayerName()) &&
                getSecondPlayerName().equals(that.getSecondPlayerName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGameMode(), getFirstPlayerName(), getSecondPlayerName(), getNumberOfFieldsHorizontally(), getNumberOfFieldsVertically());
    }

    @Override
    public String toString() {
        return "GameMenuForm{" +
                "gameMode=" + gameMode +
                ", firstPlayerName='" + firstPlayerName + '\'' +
                ", secondPlayerName='" + secondPlayerName + '\'' +
                ", numberOfFieldsHorizontally=" + numberOfFieldsHorizontally +
                ", numberOfFieldsVertically=" + numberOfFieldsVertically +
                '}';
    }
}
