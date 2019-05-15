package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> points = new ArrayList<>();
    private static final Random RANDOM = new Random();

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

}
