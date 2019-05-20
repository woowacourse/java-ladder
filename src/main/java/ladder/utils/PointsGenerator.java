package ladder.utils;

import ladder.domain.PointsTuple;
import org.apache.commons.lang3.BooleanUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PointsGenerator {
    private boolean before = false;
    private final int countOfPlayer;

    public PointsGenerator(final int countOfPlayer) {
        this.countOfPlayer = countOfPlayer;
    }

    public List<PointsTuple> generate() {
        before = false;
        List<PointsTuple> points = new ArrayList<>();
        for (int i = 0; i < countOfPlayer - 1; i++) {
            points.add(new PointsTuple(makeRandomTuple()));
        }
        points.add(new PointsTuple(Arrays.asList(before, false)));
        return points;
    }

    private List<Boolean> makeRandomTuple() {
        return Arrays.asList(before, validRandom());
    }

    private boolean validRandom() {
        if (BooleanUtils.isTrue(before)) {
            return (before = false);
        }
        return randomBoolean();
    }

    private boolean randomBoolean() {
        return (before = ((int) (Math.random() * 2) > 0));
    }
}