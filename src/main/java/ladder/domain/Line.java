package ladder.domain;

import java.util.Random;

public class Line {
    private static final int RANDOM_FACTOR = 2;
    private static final int BEFORE = 1;
    private static final int NONE = 0;
    private static final int RIGHT = 1;
    private static final int LEFT = 2;

    private int[] points;

    public Line(int countOfPerson) {
        points = new int[countOfPerson];
        addPoints();
    }

    public Line(int[] points) {
        this.points = points;
    }

    private void addPoints() {
        points[0] = getRandomLineComponent();
        for (int i = 1; i < points.length; i++) {
            points[i] = compareBeforeComponent(i);

        }
    }

    private int compareBeforeComponent(int index) {
        if (index == points.length - 1) {
            return compareLastComponent(index);
        }
        return compareNotLastComponent(points[index - BEFORE]);
    }

    private int compareNotLastComponent(int point) {
        if (point == RIGHT) {
            return LEFT;
        }
        return getRandomLineComponent();
    }

    private int compareLastComponent(int index) {
        if (points[index - BEFORE] == RIGHT) {
            return LEFT;
        }
        return NONE;
    }

    private int getRandomLineComponent() {
        return new Random().nextInt(RANDOM_FACTOR);
    }

    public int[] getPoints() {
        return points;
    }
}
