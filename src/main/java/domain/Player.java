package domain;

public class Player {

    private final PlayerName name;
    private final int startPosition;

    public Player(final String name, final int currentPosition) {
        this.name = new PlayerName(name);
        this.startPosition = currentPosition;
    }

    public String getName() {
        return name.getName();
    }

    public int getStartPosition() {
        return startPosition;
    }

}
