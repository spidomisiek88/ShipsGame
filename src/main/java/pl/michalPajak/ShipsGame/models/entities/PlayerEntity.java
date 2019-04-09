package pl.michalPajak.ShipsGame.models.entities;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.PlayersShipsBoard;

import javax.persistence.*;

@Entity
@Table(name = "player")
@Data
public class PlayerEntity{

    @Id
    @GeneratedValue
    private int id;
    @Column(name = "is_computer")
    private int isComputer;
    @Column(name = "player_name")
    private String name;
    @OneToOne(mappedBy = "player")
    private ScoreEntity score;
    private PlayersShipsBoard playerShipsBoard;

//    public boolean shot(PlayerEntity attackedPlayerEntity, int xCordinate, int yCordinate) {
//        return attackedPlayerEntity.getPlayersBoard().deleteShipToBoard(xCordinate, yCordinate);
//    }
}
