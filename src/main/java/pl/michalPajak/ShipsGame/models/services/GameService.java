package pl.michalPajak.ShipsGame.models.services;

import pl.michalPajak.ShipsGame.models.dto.Player;
import pl.michalPajak.ShipsGame.models.enums.GameMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameService {
    private GameMode gameMode;
    private Random random;
    private List<Player> players;
    private boolean isGameFinish;

    public GameService() {
        this.random = new Random();
        this.players = new ArrayList<>();
        this.isGameFinish = false;
        this.gameMode = GameMode.PLAYERTOCOMPUTER;
    }

    public boolean isGameFinish() {
        return isGameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        isGameFinish = gameFinish;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

    private Player createComputerPlayer(String playerName, int dimensionGameBoard) {
        return new Player(playerName, dimensionGameBoard, true);
    }

    private Player createPlayer(String playerName, int dimensionGameBoard) {
        return new Player(playerName, dimensionGameBoard, false);
    }

    public void setTwoPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
        players.add(createPlayer(firstPlayerName, dimensionGameBoard));
        players.add(createPlayer(secondPlayerName, dimensionGameBoard));
    }

    public void setTwoComputerPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
        players.add(createComputerPlayer(firstPlayerName, dimensionGameBoard));
        players.add(createComputerPlayer(secondPlayerName, dimensionGameBoard));
    }

    public void setPlayersAndComputerPlayers(String playerName, String computerPlayerName, int dimensionGameBoard) {
        players.add(createPlayer(playerName, dimensionGameBoard));
        players.add(createComputerPlayer(computerPlayerName, dimensionGameBoard));
    }

    public void setMultiplayer(List<String> playersNames, List<String> computerPlayersNames, int dimensionGameBoard) {
        for (String playerName : playersNames) {
            players.add(createPlayer(playerName, dimensionGameBoard));
        }

        for (String computerName : computerPlayersNames) {
            players.add(createComputerPlayer(computerName, dimensionGameBoard));
        }
    }

    private int throwOfDice() {
        return random.nextInt(6) + 1;
    }

    private void setPlayersChanceToStart() {
        for (Player player : players) {
            player.setNumberOfDots(throwOfDice());
        }
    }

    public void setOrderOfPlayers() {
        setPlayersChanceToStart();
        Collections.sort(players);
    }



//    public void gameTwoPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
//        boolean finishGame = false;
//        setTwoComputerPlayers(firstPlayerName, secondPlayerName, dimensionGameBoard);
//
//        while (!finishGame) {
//            players.get(0).s
//        }
//    }
}
