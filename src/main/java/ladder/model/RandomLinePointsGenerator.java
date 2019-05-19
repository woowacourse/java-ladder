package ladder.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomLinePointsGenerator implements LinePointsGenerator {
    private static final Random RANDOM = new Random();
    private int countOfPlayer;

    public RandomLinePointsGenerator(int countOfPlayer) {
        this.countOfPlayer = countOfPlayer;
    }

    private boolean nextPoint(boolean previous) {
        if (!previous) {
            return RANDOM.nextBoolean();
        }
        return false;
    }

    @Override
    public Points generatePoints() {
        List<Boolean> points = new ArrayList<>();
        boolean previous = false;
        for (int i = 0; i < countOfPlayer - 1; i++) {
            points.add(previous = nextPoint(previous));
        }

        return new Points(points);
    }
}
