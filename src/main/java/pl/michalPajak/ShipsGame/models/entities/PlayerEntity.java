package pl.michalPajak.ShipsGame.models.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "player")
@Data
public class PlayerEntity{

    @Id
    @GeneratedValue
    private int id;
    private int isComputer;
//    private ShipsBoard playersBoard;
    private String name;
    private String password;
    private int score;
    private int numberOfDots;

//    public boolean shot(PlayerEntity attackedPlayerEntity, int xCordinate, int yCordinate) {
//        return attackedPlayerEntity.getPlayersBoard().deleteShipToBoard(xCordinate, yCordinate);
//    }
}
