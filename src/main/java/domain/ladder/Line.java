package domain.ladder;

import domain.player.Player;
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

    public boolean isLeftSidePassable(Player player) {
        return !isLeftEnd(player) && isPassable(player.getPosition() - LEFT_POINT_CONSTANT);
    }

    private boolean isLeftEnd(Player player) {
        return player.isSamePosition(1);
    }

    private boolean isPassable(int index) {
        return points.get(index).isPassable();
    }

    public boolean isRightSidePassable(Player player) {
        return !isLastPosition(player) && isPassable(player.getPosition() - RIGHT_POINT_CONSTANT);
    }

    private boolean isLastPosition(Player player) {
        return player.isSamePosition(points.size() + 1);
    }

    public List<LinePoint> getPoints() {
        return Collections.unmodifiableList(points);
    }
}
