package ladder.domain;

public class Player {
    private final Name name;

    public Player(String nameValue) {
        this.name = new Name(nameValue);
    }

    public Name getName() {
        return name;
    }
}
