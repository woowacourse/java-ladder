package domain.ladder;

import domain.generator.BooleanGenerator;

import java.util.ArrayList;
import java.util.List;

public class Line {

    private static final String PLAYER_SIZE_ERROR_MESSAGE = "게임 참여자 수는 최소 2명 최대 50명까지 가능합니다.";
    private static final int POINTS_MIN_SIZE = 1;
    private static final int POINTS_MAX_SIZE = 49;

    private final List<Boolean> points = new ArrayList<>();

    public Line(int personCount, BooleanGenerator booleanGenerator) {
        validate(personCount);
        createPoints(personCount, booleanGenerator);
    }

    private void validate(int personCount) {
        int pointSize = personCount - 1;
        if (pointSize < POINTS_MIN_SIZE || pointSize > POINTS_MAX_SIZE) {
            throw new IllegalArgumentException(PLAYER_SIZE_ERROR_MESSAGE);
        }
    }

    private void createPoints(int personCount, BooleanGenerator booleanGenerator) {
        int pointsSize = personCount - 1;
        for (int index = 0; index < pointsSize; index++) {
            addPoint(index, booleanGenerator.generate());
        }
    }

    private void addPoint(int index, boolean flag) {
        if (PointJudge.canMake(points, flag, index)) {
            points.add(true);
            return;
        }
        points.add(false);
    }

    public List<Boolean> getPoints() {
        return points;
    }
}
