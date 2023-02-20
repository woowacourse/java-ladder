package domain;

public class Player {
    private PlayerName name;

    public Player(String name) {
        this.name = new PlayerName(name);
    }

    public String getName() {
        return name.getName();
    }
}
