package pl.michalPajak.ShipsGame;

import java.util.HashMap;
import java.util.Map;

public class ShipsBoardCreator {

    public static Map<Integer, Map<String, Integer>> createShipsBoard() {

        Map<Integer, Map<String, Integer>> shipsBoard = new HashMap<>();

        for (int i = 0; i < 10; i++)
            shipsBoard.put(i, createRowOfBoard());

        return shipsBoard;
    }

    private static Map<String, Integer> createRowOfBoard() {
        Map<String, Integer> row = new HashMap<>();
        row.put("A",0);
        row.put("B",0);
        row.put("C",0);
        row.put("D",0);
        row.put("E",0);
        row.put("F",0);
        row.put("G",0);
        row.put("H",0);
        row.put("I",0);
        row.put("J",0);

        return row;
    }
}
