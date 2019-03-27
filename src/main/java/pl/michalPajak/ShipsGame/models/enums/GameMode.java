package pl.michalPajak.ShipsGame.models.enums;

public enum GameMode {
    PLAYERTOPLAYER(1, "Gra dwuosobowa", "PLAYERTOPLAYER"),
    PLAYERTOCOMPUTER(2, "Gra jednoosobowa z komputerem", "PLAYERTOCOMPUTER"),
    COMPUTERTOCOMPUTER(3, "Gra automaczyczna z komputerem", "COMPUTERTOCOMPUTER"),
    MULTIPLAYER(4, "Gra wieloosobowa", "MULTIPLAYER");

    private int id;
    private String description;
    private String name;

    GameMode(int id, String description, String name) {
        this.id = id;
        this.description = description;
        this.name = name;
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
