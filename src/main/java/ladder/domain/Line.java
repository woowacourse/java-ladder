package ladder.domain;

public class Line {
    private static final int RANDOM_FACTOR = 2;
    private static final int BEFORE = 1;
    private static final int TRUE = 1;
    private static final int COUNT_CORRECTION = 1;
    private static final boolean NON_LINE = false;

    private boolean[] points;

    public Line(int countOfPerson) {
        points = new boolean[countOfPerson - COUNT_CORRECTION];

        points[0] = makeRandomBool();
        for (int i = 1; i < points.length; i++) {
            points[i] = compareBeforeBool(i);
        }
    }

    private boolean compareBeforeBool(int index) {
        if (isFalse(points[index - BEFORE])) {
            return makeRandomBool();
        }
        return NON_LINE;
    }

    private boolean isFalse(boolean beforeValue) {
        return !beforeValue;
    }

    private boolean makeRandomBool() {
        return (int) (Math.random() * RANDOM_FACTOR) == TRUE;
    }

    public boolean[] getPoints() {
        return points;
    }
}
