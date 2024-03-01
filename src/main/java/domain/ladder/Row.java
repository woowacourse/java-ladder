package domain.ladder;

import domain.player.PlayerCount;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Row {
    private final List<Step> steps;

    private Row(final List<Step> steps) {
        this.steps = steps;
    }

    public static Row create(final PlayerCount playerCount, final StepGenerator stepGenerator) {
        return new Row(createSteps(playerCount, stepGenerator));
    }

    private static List<Step> createSteps(final PlayerCount playerCount, final StepGenerator stepGenerator) {
        List<Step> steps = new ArrayList<>();

        for (int buildCount = 0; playerCount.isBiggerThan(buildCount); buildCount++) {
            steps.add(createStep(steps, stepGenerator, playerCount));
        }
        return steps;
    }

    private static Step createStep(final List<Step> steps, final StepGenerator stepGenerator,
                                   final PlayerCount playerCount) {
        if (hasBeforeStep(steps) || isLastStep(steps, playerCount)) {
            return Step.EMPTY;
        }
        return stepGenerator.generate();
    }

    private static boolean hasBeforeStep(final List<Step> steps) {
        final int index = steps.size();
        if (index == 0) {
            return false;
        }
        return steps.get(index - 1).isExist();
    }

    private static boolean isLastStep(final List<Step> steps, final PlayerCount playerCount) {
        return playerCount.isSameWith(steps.size() + 1);
    }

    public int playRow(int index) {
        if (steps.get(index).isExist()) {
            return index + 1;
        }
        if (index > 0 && steps.get(index - 1).isExist()) {
            return index - 1;
        }
        return index;
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Row row = (Row) o;
        return Objects.equals(steps, row.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
