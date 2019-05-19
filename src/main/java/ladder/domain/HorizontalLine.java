package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class HorizontalLine {
    private final int numPosition;
    private final List<Direction> directions;

    public HorizontalLine(List<Direction> directions) {
        this.directions = new ArrayList(directions); // 방어적 복사
        this.numPosition = directions.size();
    }

    public int getNumPosition() {
        return numPosition;
    }

    public boolean canDraw(Position left) {
        if (left.isLast()) {
            return false;
        }
        Position right = Direction.RIGHT.nextPosition(left);

        return directions.get(left.toInt()).equals(Direction.NONE)
                && directions.get(right.toInt()).equals(Direction.NONE);
    }

    public void draw(Position left) {
        Position right = Direction.RIGHT.nextPosition(left);

        directions.set(left.toInt(), Direction.RIGHT);
        directions.set(right.toInt(), Direction.LEFT);
    }

    public DrawnHorizontalLine drawn() {
        return new DrawnHorizontalLine(directions);
    }
}
