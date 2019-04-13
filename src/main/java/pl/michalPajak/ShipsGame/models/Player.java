package pl.michalPajak.ShipsGame.models;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

@Data
public class Player {

    private PlayerEntity playerEntity;
    private PlayersShipsBoard playerShipsBoard;
}
