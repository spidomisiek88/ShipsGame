package pl.michalPajak.ShipsGame.models;

import lombok.Data;

import java.util.Map;

@Data
public class PlayersShipsBoard {

    private Map<Integer, Map<String, Integer>> shipsBoard;

}
