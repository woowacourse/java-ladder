package domain.ladder;

import domain.player.Position;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public boolean isLeftPassable(Position position) {
        int targetHeight = position.getY();
        List<Bridge> targetLine = lines.get(targetHeight).getBridges();

        if (isLeftmost(position, targetLine))
            return false;

        Bridge left = targetLine.get(position.getLeft());
        return left.isPassable();
    }

    public boolean isRightPassable(Position position) {
        int targetHeight = position.getY();
        List<Bridge> targetLine = lines.get(targetHeight).getBridges();

        if (isRightmost(position, targetLine))
            return false;

        Bridge right = targetLine.get(position.getRight());
        return right.isPassable();
    }

    private boolean isLeftmost(Position position, List<Bridge> targetLine) {
        return position.getX() == 0;
    }

    private boolean isRightmost(Position position, List<Bridge> targetLine) {
        return position.getX() == targetLine.size();
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }

    public int getHeight() {
        return lines.size();
    }
}
