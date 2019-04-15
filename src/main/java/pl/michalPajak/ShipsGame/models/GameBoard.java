package pl.michalPajak.ShipsGame.models;

import lombok.Data;
import pl.michalPajak.ShipsGame.models.entities.PlayerEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class GameBoard {
    private List<Entry<PlayerEntity, PlayersShipsBoard>> players;

    public GameBoard() {
        this.players = new ArrayList<>();
    }

    public void addPlayerWithBoard(PlayerEntity playerEntity, PlayersShipsBoard playersShipsBoard) {
        this.players.add(new Entry<>(playerEntity, playersShipsBoard));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GameBoard)) return false;
        boolean equalsResult = false;
        GameBoard gameBoard = (GameBoard) o;
        if (getPlayers().size() != gameBoard.getPlayers().size())
            return false;
        else {
            for (int i = 0; i < getPlayers().size(); i++) {
                if (!getPlayers().get(i).getKey().equals(gameBoard.getPlayers().get(i).getKey()))
                    return false;
                if (!getPlayers().get(i).getValue().equals(gameBoard.getPlayers().get(i).getValue()))
                    return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPlayers());
    }
}
