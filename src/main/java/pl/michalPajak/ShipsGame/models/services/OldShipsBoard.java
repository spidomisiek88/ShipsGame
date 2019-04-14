package pl.michalPajak.ShipsGame.models.services;

import java.util.Random;

public class OldShipsBoard {
    private int[][] playersBoard;
    private int shipsCounter;

    public OldShipsBoard(int dimensionBoard) {
        this.playersBoard = new int[dimensionBoard][dimensionBoard];
        this.shipsCounter = 0;
    }

    public int getShipsCounter() {
        return shipsCounter;
    }

    public void setShipsCounter(int shipsCounter) {
        this.shipsCounter = shipsCounter;
    }

    private boolean addShipToBoard(int x, int y) {
        if (playersBoard[x][y] != 1) {
            playersBoard[x][y] = 1;
            shipsCounter++;
            return true;
        }
        return false;
    }

    public boolean deleteShipToBoard(int x, int y) {
        if (playersBoard[x][y] == 1) {
            playersBoard[x][y] = 1;
            shipsCounter--;
            return true;
        }
        return false;
    }

    public void fillComputerShipsBoard() {
        Random random = new Random();

        while (shipsCounter < 10)
            addShipToBoard(random.nextInt(), random.nextInt());
    }

    public boolean fillPlayersShipsBoard(int xCordinate, int yCordinate) {
        addShipToBoard(xCordinate, yCordinate);
        return shipsCounter < 10;
    }
}
