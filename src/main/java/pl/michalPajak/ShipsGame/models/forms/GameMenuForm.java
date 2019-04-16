package pl.michalPajak.ShipsGame.models.forms;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.enums.GameMode;

@Data
public class GameMenuForm {
    private String gameMode;
    private String firstPlayerName;
    private String secondPlayerName;
    private int numberOfFieldsHorizontally;
    private int numberOfFieldsVertically;

    public GameMenuForm() {
        this.gameMode = GameMode.PLAYERTOCOMPUTER.getName();
        this.firstPlayerName = "Player1";
        this.secondPlayerName = "Player2";
        this.numberOfFieldsHorizontally = 10;
        this.numberOfFieldsVertically = 10;
    }
}
