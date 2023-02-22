package ladder.domain;

public class Player {

    private final Name name;
    private final StartIndex startIndex;

    public Player(final Name name, final StartIndex startIndex) {
        this.name = name;
        this.startIndex = startIndex;
    }

    public String getName() {
        return name.getRawName();
    }

    public int getStartIndex() {
        return startIndex.getRawStartIndex();
    }
}
