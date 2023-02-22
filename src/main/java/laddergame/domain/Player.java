package laddergame.domain;

public class Player {
    private final PersonalName personalName;
    private int position;

    public Player(PersonalName personalName, int position) {
        this.personalName = personalName;
        this.position = position;
    }
}
