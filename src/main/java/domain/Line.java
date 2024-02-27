package domain;

import java.util.*;

public class Line {
    private final List<Step> steps;

    public Line(final PlayerCount playerCount) {
        this.steps = makeLine(playerCount);
    }

    private List<Step> makeLine(PlayerCount playerCount) {
        List<Step> steps = new ArrayList<>();
        int count = playerCount.getCount();
        for (int index = 0; index < count; index++) {
            steps.add(nextStep(steps, playerCount));
        }
        return steps;
    }

    public Step nextStep(List<Step> steps, PlayerCount playerCount) {
        if (hasBeforeStep(steps)) {
            return Step.LEFT;
        }
        if (isLastPoint(steps, playerCount)) {
            return Step.EMPTY;
        }
        Random random = new Random();
        return Step.from(random.nextBoolean());
    }

    private boolean hasBeforeStep(List<Step> steps) {
        if (isFirstPoint(steps)) {
            return false;
        }
        return steps.get(steps.size() - 1).isRight();
    }

    private boolean isFirstPoint(List<Step> steps) {
        return steps.isEmpty();
    }

    private boolean isLastPoint(List<Step> steps, PlayerCount playerCount) {
        return playerCount.isSameWith(steps.size() + 1);
    }

    public int climb(int position) {
        return steps.get(position).move(position);
    }

    public List<Step> getSteps() {
        return Collections.unmodifiableList(steps);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(steps, line.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(steps);
    }
}
