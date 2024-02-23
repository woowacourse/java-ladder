package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Line2 {
    private final List<Step> steps;

    public Line2(final List<Step> steps) {
        this.steps = steps;
    }

    public static Line of(PlayerCount playerCount, RandomStepGenerator randomBooleanGenerator) {
        return new Line(makeLine(playerCount, randomBooleanGenerator));
    }

    public static List<Step> makeLine(PlayerCount playerCount, RandomStepGenerator randomBooleanGenerator) {
        List<Step> steps = new ArrayList<>();

        for (int index = 0; isInCountRange(playerCount, index); index++) {
            steps.add(makePoint(index, steps, randomBooleanGenerator, playerCount));
        }
        return steps;
    }

    private static boolean isInCountRange(PlayerCount playerCount, int buildCount) {
        return playerCount.isBiggerThan(buildCount);
    }

    private static Step makePoint(int index, List<Step> steps, RandomStepGenerator randomStepGenerator,
                                  PlayerCount playerCount) {
        if (hasBeforeStep(index, steps) || isLastPoint(index, playerCount)) {
            return Step.EMPTY;
        }
        return randomStepGenerator.generate();
//        return new Step(step);
    }

    private static boolean hasBeforeStep(int index, List<Step> steps) {
        if (isFirstPoint(index)) {
            return false;
        }
        return steps.get(index - 1).isExist();
    }

    private static boolean isLastPoint(int index, PlayerCount playerCount) {
        return playerCount.isSameWith(index + 1);
    }

    private static boolean isFirstPoint(int index) {
        return index == 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Line2 line2 = (Line2) o;
        return Objects.equals(steps, line2.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }

    public List<Step> getPoints() {
        return Collections.unmodifiableList(steps);
    }
}
