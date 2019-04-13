package pl.michalPajak.ShipsGame.models;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

@Data
public class GameBoard {
    private PlayerEntity firstPlayer;
    private PlayerEntity secondPlayer;
    private PlayersShipsBoard firstPlayersBoard;
    private PlayersShipsBoard secondPlayersBoard;
}
