package model.ladder;

import static model.laddergame.Direction.LEFT;
import static model.laddergame.Direction.RIGHT;
import static model.laddergame.Direction.STRAIGHT;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import model.ladder.generator.StepStatusGenerator;
import model.laddergame.Direction;
import model.players.Position;

public class Line {
    private final List<Step> steps;

    public Line(List<Step> steps) {
        this.steps = steps;
    }

    public static Line from(final Width width, final StepStatusGenerator generator) {
        List<Step> steps = new ArrayList<>();
        Step previous = Step.from(StepStatus.EMPTY);
        while (steps.size() < width.size()) {
            Step step = Step.of(previous, generator);
            steps.add(step);
            previous = step;
        }
        return new Line(steps);
    }

    public Direction getDirection(Position position) {
        if (isNotLast(position) && isRightConnected(position)) {
            return RIGHT;
        }
        if (isNotFirst(position) && isLeftConnected(position)) {
            return LEFT;
        }
        return STRAIGHT;
    }

    private boolean isRightConnected(Position position) {
        return getRightStep(position).isConnected();
    }

    private Step getRightStep(final Position position) {
        return steps.get(position.getValue());
    }

    private boolean isLeftConnected(Position position) {
        return getLeftStep(position).isConnected();
    }

    private Step getLeftStep(final Position position) {
        return steps.get(position.getValue() - 1);
    }

    private boolean isNotLast(final Position position) {
        return position.doesNotMatch(steps.size());
    }

    private boolean isNotFirst(final Position position) {
        return position.doesNotMatch(0);
    }

    public int size() {
        return steps.size();
    }

    public boolean isConnected(final int index) {
        return steps.get(index).isConnected();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Line line = (Line) o;
        return Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
