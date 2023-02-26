package ladder.domain.ladderNode;

import ladder.domain.Ladder;

public class Player {
    private final Name name;
    private final Position position;

    public Player(String name, int startPoint) {
        this.name = new Name(name);
        this.position = Position.from(startPoint);
    }

    public Position moveThroughLadder(Ladder ladder) {
        Position resultPosition = ladder.moveThrough(position);
        return resultPosition;
    }

    public boolean isEqualName(String inputName) {
        return name.equals(new Name(inputName));
    }

    public String getName() {
        return name.getName();
    }

    public int getNameLength() {
        return name.getNameLength();
    }
}
