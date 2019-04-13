package pl.michalPajak.ShipsGame.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.services.PlayersShipsBoardService;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PlayersShipsBoardServiceTest {

    @Autowired
    PlayersShipsBoardService playersShipsBoardService;

    @Test
    public void shouldInitializePlayersShipsBoard() {
        int numberOfFieldsHorizontally = 10;
        int numberOfFieldsVertically = 10;

        PlayersShipsBoard expectesPlayersShipsBoard = new PlayersShipsBoard();
        expectesPlayersShipsBoard.setShipsBoard(createShipsBoard());
        expectesPlayersShipsBoard.setShipsCounter(0);

        PlayersShipsBoard actualPlayersShipsBoard = playersShipsBoardService
                .initializePlayersShipsBoard(numberOfFieldsHorizontally, numberOfFieldsVertically);

        Assertions.assertEquals(expectesPlayersShipsBoard.getShipsBoard(), actualPlayersShipsBoard.getShipsBoard());
        Assertions.assertEquals(expectesPlayersShipsBoard.getShipsCounter(), actualPlayersShipsBoard.getShipsCounter());
    }

    private Map<Integer, Map<String, Integer>> createShipsBoard() {

        Map<Integer, Map<String, Integer>> shipsBoard = new HashMap<>();

        for (int i = 0; i < 10; i++)
            shipsBoard.put(i, createRowOfBoard());

        return shipsBoard;
    }

    private Map<String, Integer> createRowOfBoard() {
        Map<String, Integer> row = new HashMap<>();
        row.put("A",0);
        row.put("B",0);
        row.put("C",0);
        row.put("D",0);
        row.put("E",0);
        row.put("F",0);
        row.put("G",0);
        row.put("H",0);
        row.put("I",0);
        row.put("J",0);

        return row;
    }
}
