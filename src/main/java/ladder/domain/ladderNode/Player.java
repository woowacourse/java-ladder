package ladder.domain.ladderNode;

import ladder.domain.Ladder;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int startPoint) {
        this.name = new Name(name);
        this.position = new Position(startPoint);
    }

    public Position moveThroughLadder(Ladder ladder) {
        int resultPosition = ladder.moveThrough(position.getPosition());
        return new Position(resultPosition);
    }

    public boolean isEqualName(String inputName) {
        return name.equals(inputName);
    }

    public String getName() {
        return name.getName();
    }

    public int getNameLength() {
        return name.getNameLength();
    }
}
