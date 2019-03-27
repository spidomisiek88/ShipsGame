package pl.michalPajak.ShipsGame.models.enums;

public enum MenuMode {
    GAMEMODE(1, "Wybierz tryb gry.", "GAMEMODE"),
    STARTGAME(2, "Rozpocznij grę.", "SRARTGAME"),
    EXIT(3, "Zamknij program.", "EXIT");

    private int id;
    private String description;
    private String name;

    MenuMode(int id, String description, String name) {
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
}
