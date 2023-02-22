package laddergame.domain;

public class Player {
    private final PersonalName personalName;
    private Position position;

    public Player(PersonalName personalName, int value) {
        this.personalName = personalName;
        this.position = new Position(value);
    }
}
