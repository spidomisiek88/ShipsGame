package pl.michalPajak.ShipsGame.models.dto;

import pl.michalPajak.ShipsGame.models.services.ShipsBoard;

import java.util.Objects;

public class Player implements Comparable {
    private boolean isComputer;
    private ShipsBoard playersBoard;
    private String name;
    private int score;
    private int numberOfDots;

    public Player(String name, int dimensionBoard, boolean isComputer) {
        this.name = name;
        this.score = 0;
        this.numberOfDots = 0;
        this.isComputer = isComputer;
        this.playersBoard = new ShipsBoard(dimensionBoard);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ShipsBoard getPlayersBoard() {
        return playersBoard;
    }

    public void setPlayersBoard(ShipsBoard playersBoard) {
        this.playersBoard = playersBoard;
    }

    public int getNumberOfDots() {
        return numberOfDots;
    }

    public void setNumberOfDots(int numberOfDots) {
        this.numberOfDots = numberOfDots;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player)) return false;
        Player player = (Player) o;
        return getScore() == player.getScore() &&
                Objects.equals(getName(), player.getName());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getScore());
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

    public boolean shot(Player attackedPlayer,int xCordinate, int yCordinate) {
        return attackedPlayer.getPlayersBoard().deleteShipToBoard(xCordinate, yCordinate);
    }

    @Override
    public int compareTo(Object o) {
        if (this.numberOfDots < ((Player) o).getNumberOfDots())
            return -1;
        else if (this.numberOfDots > ((Player) o).getNumberOfDots())
            return 1;
        return 0;
    }
}
