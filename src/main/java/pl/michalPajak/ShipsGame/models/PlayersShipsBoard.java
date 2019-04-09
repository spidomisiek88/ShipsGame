package pl.michalPajak.ShipsGame.models;

import lombok.Data;

import java.util.Map;

@Data
public class PlayerShipsBoard {

    private Map<Integer, Map<Character, Integer>> shipsBoard;

}
