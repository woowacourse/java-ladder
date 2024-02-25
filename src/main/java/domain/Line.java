package domain;

import java.util.*;

public class Line {
    private final List<Step> steps;

    private Line(final List<Step> steps) {
        this.steps = steps;
    }

    public static Line create(PlayerCount playerCount) {
        return new Line(makeLine(playerCount));
    }

    private static List<Step> makeLine(PlayerCount playerCount) {
        List<Step> steps = new ArrayList<>();
        int count = playerCount.getCount();
        for (int index = 0; index < count; index++) {
            steps.add(makeStep(steps, playerCount));
        }
        return steps;
    }

    private static Step makeStep(List<Step> steps, PlayerCount playerCount) {
        if (hasBeforeStep(steps)) {
            return Step.LEFT;
        }
        if (isLastPoint(steps, playerCount)) {
            return Step.EMPTY;
        }
        Random random = new Random();
        return Step.from(random.nextBoolean());
    }

    private static boolean hasBeforeStep(List<Step> steps) {
        if (isFirstPoint(steps)) {
            return false;
        }
        return steps.get(steps.size() - 1).isRight();
    }

    private static boolean isFirstPoint(List<Step> steps) {
        return steps.isEmpty();
    }

    private static boolean isLastPoint(List<Step> steps, PlayerCount playerCount) {
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
