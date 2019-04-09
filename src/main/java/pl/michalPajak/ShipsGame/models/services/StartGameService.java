package pl.michalPajak.ShipsGame.models.services;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.GameBoard;
import pl.michalPajak.ShipsGame.models.forms.GameMenuForm;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

@Service
@Data
public class StartGameService {

    @Autowired
    PlayerService playerService;
    GameBoard shipsBoard;

    public GameBoard startGame(GameMenuForm gameMenuForm) {
        shipsBoard = new GameBoard();

        PlayerEntity firstPlayerEntity = playerService.initializePlayer(gameMenuForm.getFirstPlayerName(),
                gameMenuForm.getGameMode().isFirstPlayerComputer());

        PlayerEntity secondPlayerEntity = playerService.initializePlayer(gameMenuForm.getSecondPlayerName(),
                gameMenuForm.getGameMode().isSecondPlayerComputer());

        shipsBoard.setFirstPlayer(firstPlayerEntity);
        shipsBoard.setSecondPlayer(secondPlayerEntity);



        return shipsBoard;
    }



}
