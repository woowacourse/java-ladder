package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private static final Random RANDOM = new Random();
    private static final String EMPTY_LINE = "     ";
    private static final String FILLED_LINE = "-----";
    private static final String VERTICAL_LINE = "|";

    private List<Boolean> points = new ArrayList<>();

    public Line(int countOfPlayer) {
        this.pointsInit(countOfPlayer);
    }

    private void pointsInit(int countOfPlayer) {
        boolean previous = false;
        for (int i = 0; i < countOfPlayer - 1; i++) {
            previous = nextPoint(previous);
            points.add(previous);
        }
        this.checkPointsValid();
    }

    private boolean nextPoint(boolean previous) {
        if (!previous) {
            return RANDOM.nextBoolean();
        }
        return false;
    }

    public int lineSize() {
        return this.points.size();
    }

    public void checkPointsValid() {
        for (int i = 1; i < this.lineSize(); i++) {
            checkContinued(i - 1, i);
        }
    }

    private void checkContinued(int left, int right) {
        if (this.points.get(left) && this.points.get(right)) {
            throw new IllegalArgumentException("이어지는 가로라인 발생");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(VERTICAL_LINE);
        for (int i = 0; i < lineSize(); i++) {
            stringBuilder.append(getOne(i)).append(VERTICAL_LINE);
        }
        return stringBuilder.toString();
    }

    private String getOne(int pointIndex) {
        if (this.points.get(pointIndex)) {
            return FILLED_LINE;
        }
        return EMPTY_LINE;
    }

}
