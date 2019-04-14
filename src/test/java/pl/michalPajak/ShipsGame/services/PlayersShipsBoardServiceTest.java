package pl.michalPajak.ShipsGame.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.ShipsGame.ShipsBoardCreator;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.services.PlayersShipsBoardService;

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
        expectesPlayersShipsBoard.setShipsBoard(ShipsBoardCreator.createShipsBoard());
        expectesPlayersShipsBoard.setShipsCounter(0);

        PlayersShipsBoard actualPlayersShipsBoard = playersShipsBoardService
                .initializePlayersShipsBoard(numberOfFieldsHorizontally, numberOfFieldsVertically);

        Assertions.assertEquals(expectesPlayersShipsBoard.getShipsBoard(), actualPlayersShipsBoard.getShipsBoard());
        Assertions.assertEquals(expectesPlayersShipsBoard.getShipsCounter(), actualPlayersShipsBoard.getShipsCounter());
    }
}
