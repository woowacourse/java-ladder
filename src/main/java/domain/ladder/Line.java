package domain.ladder;

import domain.player.Position;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {

    private static final int LEFT_POINT_CONSTANT = 2;
    private static final int RIGHT_POINT_CONSTANT = 1;

    private final List<LinePoint> points;

    public Line(List<LinePoint> points) {
        this.points = new ArrayList<>(points);
    }

    public boolean isLeftSidePassable(Position position) {
        return !isLeftEnd(position) && isPassable(position.getPosition() - LEFT_POINT_CONSTANT);
    }

    private boolean isLeftEnd(Position position) {
        return position.isSamePosition(1) ;
    }

    private boolean isPassable(int index) {
        return points.get(index).isPassable();
    }

    public boolean isRightSidePassable(Position position) {
        return !isLastPosition(position) && isPassable(position.getPosition() - RIGHT_POINT_CONSTANT);
    }

    private boolean isLastPosition(Position position) {
        return position.isSamePosition(points.size() + 1);
    }

    public List<LinePoint> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
