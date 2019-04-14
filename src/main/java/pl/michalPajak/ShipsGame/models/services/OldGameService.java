package pl.michalPajak.ShipsGame.models.services;

import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;
import pl.michalPajak.ShipsGame.models.enums.GameMode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class OldGameService {
    private GameMode gameMode;
    private Random random;
    private List<PlayerEntity> playerEntities;
    private boolean isGameFinish;

    public OldGameService() {
        this.random = new Random();
        this.playerEntities = new ArrayList<>();
        this.isGameFinish = false;
        this.gameMode = GameMode.PLAYERTOCOMPUTER;
    }

    public boolean isGameFinish() {
        return isGameFinish;
    }

    public void setGameFinish(boolean gameFinish) {
        isGameFinish = gameFinish;
    }

    public List<PlayerEntity> getPlayerEntities() {
        return playerEntities;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public void setGameMode(GameMode gameMode) {
        this.gameMode = gameMode;
    }

//    private PlayerEntity createComputerPlayer(String playerName, int dimensionGameBoard) {
//        return new PlayerEntity(playerName, dimensionGameBoard, true);
//    }
//
//    private PlayerEntity createPlayer(String playerName, int dimensionGameBoard) {
//        return new PlayerEntity(playerName, dimensionGameBoard, false);
//    }

//    public void setTwoPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
//        playerEntities.add(createPlayer(firstPlayerName, dimensionGameBoard));
//        playerEntities.add(createPlayer(secondPlayerName, dimensionGameBoard));
//    }
//
//    public void setTwoComputerPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
//        playerEntities.add(createComputerPlayer(firstPlayerName, dimensionGameBoard));
//        playerEntities.add(createComputerPlayer(secondPlayerName, dimensionGameBoard));
//    }
//
//    public void setPlayersAndComputerPlayers(String playerName, String computerPlayerName, int dimensionGameBoard) {
//        playerEntities.add(createPlayer(playerName, dimensionGameBoard));
//        playerEntities.add(createComputerPlayer(computerPlayerName, dimensionGameBoard));
//    }
//
//    public void setMultiplayer(List<String> playersNames, List<String> computerPlayersNames, int dimensionGameBoard) {
//        for (String playerName : playersNames) {
//            playerEntities.add(createPlayer(playerName, dimensionGameBoard));
//        }
//
//        for (String computerName : computerPlayersNames) {
//            playerEntities.add(createComputerPlayer(computerName, dimensionGameBoard));
//        }
//    }

    private int throwOfDice() {
        return random.nextInt(6) + 1;
    }

//    private void setPlayersChanceToStart() {
//        for (PlayerEntity playerEntity : playerEntities) {
//            playerEntity.setNumberOfDots(throwOfDice());
//        }
//    }

//    public void setOrderOfPlayers() {
//        setPlayersChanceToStart();
//        Collections.sort(playerEntities);
//    }



//    public void gameTwoPlayers(String firstPlayerName, String secondPlayerName, int dimensionGameBoard) {
//        boolean finishGame = false;
//        setTwoComputerPlayers(firstPlayerName, secondPlayerName, dimensionGameBoard);
//
//        while (!finishGame) {
//            playerEntities.get(0).s
//        }
//    }
}
