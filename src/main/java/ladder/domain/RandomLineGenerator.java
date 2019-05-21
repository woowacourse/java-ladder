package ladder.domain;

import ladder.utils.RandomValueUtils;

import java.util.ArrayList;
import java.util.List;

public class RandomLineGenerator implements LineGenerator {
    @Override
    public Line generate(int numberOfPeople) {
        List<Boolean> points = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            boolean isConnected = connectRandomly(i, points, numberOfPeople);
            points.add(isConnected);
        }

        return new Line(points);
    }

    private boolean connectRandomly(int index, List<Boolean> points, int numberOfPeople) {
        if (index == 0 || (index != numberOfPeople - 1 && !points.get(index - 1))) {
            return RandomValueUtils.generate();
        }

        return false;
    }
}
