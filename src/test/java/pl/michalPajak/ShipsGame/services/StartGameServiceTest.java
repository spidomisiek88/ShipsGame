package pl.michalPajak.ShipsGame.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.ShipsGame.ShipsBoardCreator;
import pl.michalPajak.ShipsGame.models.GameBoard;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;
import pl.michalPajak.ShipsGame.models.enums.GameMode;
import pl.michalPajak.ShipsGame.models.forms.GameMenuForm;
import pl.michalPajak.ShipsGame.models.repositoris.PlayerRepository;
import pl.michalPajak.ShipsGame.models.services.PlayerService;
import pl.michalPajak.ShipsGame.models.services.StartGameService;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class StartGameServiceTest {

//    @Mock
    @Spy
    PlayerRepository playerRepository;

    @InjectMocks
    PlayerService playerService;
    @InjectMocks
    @Autowired
    StartGameService startGameService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInitializeGameBoard() {

        GameMenuForm gameMenuForm = new GameMenuForm();
        gameMenuForm.setFirstPlayerName("Spido1");
        gameMenuForm.setSecondPlayerName("Spido2");
        gameMenuForm.setGameMode(GameMode.PLAYERTOCOMPUTER.getName());

        PlayerEntity firstPlayerEntity = new PlayerEntity();
        firstPlayerEntity.setId(1);
        firstPlayerEntity.setName(gameMenuForm.getFirstPlayerName());
        firstPlayerEntity.setIsComputer(0);
        firstPlayerEntity.setScore(null);

        PlayersShipsBoard firstPlayersShipsBoard = new PlayersShipsBoard();
        firstPlayersShipsBoard.setShipsBoard(ShipsBoardCreator.createShipsBoard());
        firstPlayersShipsBoard.setShipsCounter(0);

        PlayerEntity secondPlayerEntity = new PlayerEntity();
        secondPlayerEntity.setId(2);
        secondPlayerEntity.setName(gameMenuForm.getSecondPlayerName());
        secondPlayerEntity.setIsComputer(1);
        secondPlayerEntity.setScore(null);

        PlayersShipsBoard secondPlayersShipsBoard = new PlayersShipsBoard();
        secondPlayersShipsBoard.setShipsBoard(ShipsBoardCreator.createShipsBoard());
        secondPlayersShipsBoard.setShipsCounter(0);

        GameBoard expectesGameBoard = new GameBoard();
        expectesGameBoard.addPlayerWithBoard(firstPlayerEntity, firstPlayersShipsBoard);
        expectesGameBoard.addPlayerWithBoard(secondPlayerEntity, secondPlayersShipsBoard);

        Mockito.when(playerRepository.findPlayerByName("Spido1")).thenReturn(Optional.empty());
        Mockito.when(playerRepository.findPlayerByName("Spido2")).thenReturn(Optional.empty());
//        Mockito.when(playerRepository.save(Mockito.any(PlayerEntity.class))).thenReturn(firstPlayerEntity);
//        Mockito.when(playerRepository.save(Mockito.any(PlayerEntity.class))).thenReturn(secondPlayerEntity);
        Mockito.doReturn(firstPlayerEntity).when(Mockito.spy(playerRepository)).save(firstPlayerEntity);
        Mockito.doReturn(secondPlayerEntity).when(Mockito.spy(playerRepository)).save(secondPlayerEntity);

        GameBoard actualGameBoard = startGameService.initializeGameBoard(gameMenuForm);

        Assertions.assertEquals(expectesGameBoard, actualGameBoard);
    }
}
