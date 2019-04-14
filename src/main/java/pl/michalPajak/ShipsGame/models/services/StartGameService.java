package pl.michalPajak.ShipsGame.models.services;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.GameBoard;
import pl.michalPajak.ShipsGame.models.Player;
import pl.michalPajak.ShipsGame.models.forms.GameMenuForm;

@Service
@Data
public class StartGameService {

    @Autowired
    PlayerService playerService;
    @Autowired
    PlayersShipsBoardService playersShipsBoardService;
    GameBoard shipsBoard;

    public GameBoard initializeGameBoard(GameMenuForm gameMenuForm) {
        shipsBoard = new GameBoard();

        Player firstPlayer = playerService.initializePlayer(gameMenuForm.getFirstPlayerName(),
                gameMenuForm.getGameMode().isFirstPlayerComputer());

        Player secondPlayer = playerService.initializePlayer(gameMenuForm.getSecondPlayerName(),
                gameMenuForm.getGameMode().isSecondPlayerComputer());

        shipsBoard.setFirstPlayer(firstPlayer.getPlayerEntity());
        shipsBoard.setSecondPlayer(secondPlayer.getPlayerEntity());
        shipsBoard.setFirstPlayersBoard(playersShipsBoardService
                .initializePlayersShipsBoard(gameMenuForm.getNumberOfFieldsHorizontally(),
                        gameMenuForm.getNumberOfFieldsVertically()));
        shipsBoard.setSecondPlayersBoard(playersShipsBoardService
                .initializePlayersShipsBoard(gameMenuForm.getNumberOfFieldsHorizontally(),
                        gameMenuForm.getNumberOfFieldsVertically()));

        return shipsBoard;
    }



}
