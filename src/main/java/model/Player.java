package model;

public class Player {
    private final Name name;
    private Result result;
    private Position position;

    public Player(final Name name, final Position position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name.getValue();
    }

    public String getResult() {
        return result.getValue();
    }

    public void saveResult(final Result result) {
        this.result = result;
    }

    public boolean isPlayerName(Name other) {
        return other.isSame(this.name);
    }

    public boolean isPlayerPosition(Position otherPosition) {
        return otherPosition.isSamePosition(this.position);
    }

    public void changePositionWith(Player otherPlayer) {
        Position temporaryPosition = otherPlayer.position;
        otherPlayer.position = this.position;
        this.position = temporaryPosition;
    }
}
