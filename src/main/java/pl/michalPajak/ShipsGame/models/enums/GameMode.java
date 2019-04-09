package pl.michalPajak.ShipsGame.models.enums;

public enum GameMode {
    PLAYERTOPLAYER(1, "Gra dwuosobowa", "PLAYERTOPLAYER", false, false),
    PLAYERTOCOMPUTER(2, "Gra jednoosobowa z komputerem", "PLAYERTOCOMPUTER", false, true),
    COMPUTERTOCOMPUTER(3, "Gra automaczyczna z komputerem", "COMPUTERTOCOMPUTER", true, true),
    MULTIPLAYER(4, "Gra wieloosobowa", "MULTIPLAYER", false, false);

    private int id;
    private String description;
    private String name;
    private boolean isFirstPlayerComputer;
    private boolean isSecondPlayerComputer;

    GameMode(int id, String description, String name, boolean firstPlayerIsComputer, boolean secondPlayerIsComputer) {
        this.id = id;
        this.description = description;
        this.name = name;
        this.isFirstPlayerComputer = firstPlayerIsComputer;
        this.isSecondPlayerComputer = secondPlayerIsComputer;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }

    public boolean isFirstPlayerComputer() {
        return isFirstPlayerComputer;
    }

    public boolean isSecondPlayerComputer() {
        return isSecondPlayerComputer;
    }

    @Override
    public String toString() {
        return "GameMode{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public static GameMode valueOfById(int id) {
        for (GameMode gameMode : values()) {
            if (id == gameMode.getId())
                return gameMode;
            else
                throw new IllegalArgumentException();
        }
        return null;
    }
}
