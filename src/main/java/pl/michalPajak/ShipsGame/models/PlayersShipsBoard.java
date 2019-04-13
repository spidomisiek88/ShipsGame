package pl.michalPajak.ShipsGame.models;

import lombok.Data;

import java.util.Map;

@Data
public class PlayersShipsBoard {

    private int shipsCounter;
    private Map<Integer, Map<String, Integer>> shipsBoard;

}
