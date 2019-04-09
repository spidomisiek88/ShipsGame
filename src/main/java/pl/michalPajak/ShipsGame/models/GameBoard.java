package pl.michalPajak.ShipsGame.models;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

@Data
public class ShipsBoard {
    private PlayerEntity firstPlayer;
    private PlayerEntity secondPlayer;


}
