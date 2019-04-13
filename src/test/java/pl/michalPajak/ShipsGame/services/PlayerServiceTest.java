package pl.michalPajak.ShipsGame.services;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.michalPajak.ShipsGame.models.Player;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;
import pl.michalPajak.ShipsGame.models.repositoris.PlayerRepository;
import pl.michalPajak.ShipsGame.models.services.PlayerService;

import java.util.Map;
import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class PlayerServiceTest {

    @Mock
    PlayerRepository playerRepository;
    @InjectMocks
    PlayerService playerService;

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldInitializeNewPlayer() {
        String playerName = "Spido";
        boolean isComputer = false;

        PlayersShipsBoard playersShipsBoard = new PlayersShipsBoard();
        Map<Integer, Map<String, Integer>> shipsBoard =  null;
        playersShipsBoard.setShipsBoard(shipsBoard);

        PlayerEntity playerEntity = new PlayerEntity();
        playerEntity.setId(0);
        playerEntity.setName(playerName);
        playerEntity.setIsComputer(0);
        playerEntity.setScore(null);

        Player expectesPlayer = new Player();
        expectesPlayer.setPlayerEntity(playerEntity);
        expectesPlayer.setPlayerShipsBoard(playersShipsBoard);


        Mockito.when(playerRepository.findPlayerByName("Spido")).thenReturn(Optional.empty());

        Player actualPlayer = playerService.initializePlayer(playerName, isComputer);

        Assertions.assertEquals(expectesPlayer, actualPlayer);
        Assertions.assertEquals(expectesPlayer.getPlayerEntity().getId(), actualPlayer.getPlayerEntity().getId());
        Assertions.assertEquals(expectesPlayer.getPlayerEntity().getName(), actualPlayer.getPlayerEntity().getName());
        Assertions.assertEquals(expectesPlayer.getPlayerEntity().getIsComputer(), actualPlayer.getPlayerEntity().getIsComputer());
        Assertions.assertEquals(expectesPlayer.getPlayerShipsBoard(), actualPlayer.getPlayerShipsBoard());
        Assertions.assertEquals(expectesPlayer.getPlayerEntity().getScore(), actualPlayer.getPlayerEntity().getScore());
    }
}
