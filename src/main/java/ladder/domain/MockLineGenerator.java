package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class MockLineGenerator implements LineBuilder {
    @Override
    public Line generate(int numberOfPeople) {
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            boolean isConnected = connect(i, points, numberOfPeople);
            points.add(isConnected);
        }

        return new Line(points);
    }

    private boolean connect(int index, List<Boolean> points, int numberOfPeople) {
        if (index == 0) return true;
        if (index == numberOfPeople - 1 || points.get(index - 1)) return false;
        return true;
    }
}
