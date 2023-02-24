package domain.ladder;

import domain.Direction;
import domain.player.Player;
import util.TrueOrFalseGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private static final int FIRST_INDEX = 0;
    private static final boolean NON_PASS = false;
    private final List<Point> points;

    public Line(List<Point> points) {
        this.points = Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    public static Line generate(int personCount, TrueOrFalseGenerator trueOrFalseGenerator) {
        List<Point> points = new ArrayList<>();
        for (int count = 0; count < personCount - 1; count++) {
            points.add(correctOverLapPoints(points, new Point(trueOrFalseGenerator.generate())));
        }
        return new Line(points);
    }

    private static Point correctOverLapPoints(List<Point> points, Point current) {
        if (points.size() == FIRST_INDEX) {
            return current;
        }
        Point beforPoint = points.get(points.size() - 1);
        if (beforPoint.isPoint()) {
            return current.nonPass();
        }
        return current;
    }

    public Direction getDirection(Player player) {
        if (checkSidePosition(player)) {
            return moveSidePosition(player.getPosition());
        }
        return judge(points.get(player.getPosition() - 1).isPoint(), points.get(player.getPosition()).isPoint());
    }

    public boolean checkSidePosition(Player player) {
        return player.getPosition() == 0 || player.getPosition() == points.size();
    }

    public Direction moveSidePosition(int playerPosition) {
        if (playerPosition == 0) {
            return judge(NON_PASS, points.get(playerPosition).isPoint());
        }
        return judge(points.get(playerPosition - 1).isPoint(), NON_PASS);
    }

    private Direction judge(boolean left, boolean right) {
        if (left) {
            return Direction.LEFT;
        }
        if (right) {
            return Direction.RIGHT;
        }
        return Direction.STAY;
    }
}
