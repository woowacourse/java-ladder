package domain;

public class Player {

    private final Name name;
    private int currentColumnPosition;

    public Player(final Name name, final int startPosition) {
        this.name = name;
        this.currentColumnPosition = startPosition;
    }

}
