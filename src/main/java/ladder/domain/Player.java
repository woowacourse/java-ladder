package ladder.domain;

public class Player {

    private final Name name;
    private final int startIndex;

    public Player(final Name name, final int startIndex) {
        this.name = name;
        this.startIndex = startIndex;
    }

    public Name getName() {
        return name;
    }
}
