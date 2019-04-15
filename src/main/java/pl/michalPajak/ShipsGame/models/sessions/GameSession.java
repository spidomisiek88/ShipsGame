package pl.michalPajak.ShipsGame.models.sessions;

import lombok.Data;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import pl.michalPajak.ShipsGame.models.Entry;
import pl.michalPajak.ShipsGame.models.GameBoard;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

@Service
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Data
public class GameSession {

    private GameBoard gameBoard;
    private int whichPlayersTurn;

    public GameSession() {
        this.gameBoard = new GameBoard();
    }

    public void nextPlayersTurn() {
        if (whichPlayersTurn < gameBoard.getPlayers().size())
            whichPlayersTurn++;
        else
            whichPlayersTurn = 0;
    }

    public Entry<PlayerEntity, PlayersShipsBoard> getActualTurn(){
        return gameBoard.getPlayers().get(whichPlayersTurn);
    }
}
