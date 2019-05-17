package ladder.domain;

import java.util.Random;

public class Line {
    private static final int RANDOM_FACTOR = 2;
    private static final int BEFORE = 1;

    private Direction[] points;

    public Line(int countOfPerson) {
        points = new Direction[countOfPerson];
        addPoints();
    }   

    public Line(Direction[] points) {
        this.points = points;
    }

    private void addPoints() {
        points[0] = addFirstComponent();
        for (int i = 1; i < points.length; i++) {
            points[i] = compareBeforeComponent(i);
        }
    }

    private Direction addFirstComponent() {
        if (points.length == 1) {
            return Direction.STRAIGHT;
        }
        return Direction.valueOf(getRandomLineComponent());
    }

    private Direction compareBeforeComponent(int index) {
        if (index == points.length - BEFORE) {
            return compareLastComponent(index);
        }
        return compareNotLastComponent(points[index - BEFORE]);
    }

    private Direction compareNotLastComponent(Direction point) {
        if (point == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.valueOf(getRandomLineComponent());
    }

    private Direction compareLastComponent(int index) {
        if (points[index - BEFORE] == Direction.RIGHT) {
            return Direction.LEFT;
        }
        return Direction.STRAIGHT;
    }

    private int getRandomLineComponent() {
        return new Random().nextInt(RANDOM_FACTOR);
    }

    public Direction[] getPoints() {
        return points;
    }
}
