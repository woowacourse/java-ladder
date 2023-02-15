package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {

    public static final int POINT_MIN_SIZE = 1;
    public static final int POINT_MAX_SIZE = 20;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int pointSize) {
        validate(pointSize);
        generatePoints(pointSize);
    }

    private void validate(int pointSize) {
        if (pointSize < POINT_MIN_SIZE || pointSize > POINT_MAX_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void generatePoints(final int pointSize) {
        // TODO: Random 객체 외부에서 주입받아서 사용하도록 수정
        Random random = new Random();

        for (int i = 0; i < pointSize; i++) {
            boolean leftPoint = false;
            boolean currentPoint = false;
            if (i - 1 >= 0) {
                leftPoint = points.get(i - 1);
            }
            if (!leftPoint) {
                currentPoint = random.nextBoolean();
            }
            points.add(currentPoint);
        }
    }

    public boolean getPointAt(int index) {
        return points.get(index);
    }
}
