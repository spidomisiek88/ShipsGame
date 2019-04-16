package pl.michalPajak.ShipsGame.models.services;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.GameBoard;
import pl.michalPajak.ShipsGame.models.Player;
import pl.michalPajak.ShipsGame.models.enums.GameMode;
import pl.michalPajak.ShipsGame.models.forms.GameMenuForm;
import pl.michalPajak.ShipsGame.models.sessions.GameSession;

@Service
@Data
public class StartGameService {

    private final static int FIRST_PLAYER_INDEX = 0;

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayersShipsBoardService playersShipsBoardService;
    @Autowired
    GameSession gameSession;

    public GameBoard initializeGameBoard(GameMenuForm gameMenuForm) {

        Player firstPlayer = playerService.initializePlayer(gameMenuForm.getFirstPlayerName(),
                GameMode.valueOf(gameMenuForm.getGameMode()).isFirstPlayerComputer());

        Player secondPlayer = playerService.initializePlayer(gameMenuForm.getSecondPlayerName(),
                GameMode.valueOf(gameMenuForm.getGameMode()).isSecondPlayerComputer());

        gameSession.getGameBoard().addPlayerWithBoard(firstPlayer.getPlayerEntity(), playersShipsBoardService
                .initializePlayersShipsBoard(gameMenuForm.getNumberOfFieldsHorizontally(),
                        gameMenuForm.getNumberOfFieldsVertically()));

        gameSession.getGameBoard().addPlayerWithBoard(secondPlayer.getPlayerEntity(), playersShipsBoardService
                .initializePlayersShipsBoard(gameMenuForm.getNumberOfFieldsHorizontally(),
                        gameMenuForm.getNumberOfFieldsVertically()));

        gameSession.setWhichPlayersTurn(FIRST_PLAYER_INDEX);

        return gameSession.getGameBoard();
    }



}
