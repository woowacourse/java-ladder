package domain;

public class Player {

    private final String name;
    private final int position;

    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }
}
