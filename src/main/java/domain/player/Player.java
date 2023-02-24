package domain.player;

import domain.ladder.Ladder;
import domain.ladder.Line;
import java.util.List;

public class Player {

    private final Name name;
    private Position position;

    public Player(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public boolean isSameName(String otherName) {
        return name.isSame(otherName);
    }

    public Position move(Ladder ladder) {
        List<Line> lines = ladder.getLines();

        for (Line line : lines) {
            moveEachLine(line);
        }

        return position;
    }

    private void moveEachLine(Line line) {
        if (position.isLeftSidePassable(line)) {
            position.moveLeft();
            return;
        }

        if (position.isRightSidePassable(line)) {
            position.moveRight();
        }
    }

    public String getName() {
        return name.getName();
    }
}
