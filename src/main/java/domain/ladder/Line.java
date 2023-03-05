package domain.ladder;

import domain.player.Player;
import java.util.List;
import java.util.stream.Collectors;

public class Line {

    private final List<Step> steps;
    public Line(final List<Step> steps) {
        this.steps = steps;
    }

    public int getWidth() {
        if (this.steps.isEmpty()) {
            return 0;
        }

        return this.steps.size();
    }

    public List<Boolean> getRightConnectionCondition() {
        return List.copyOf(steps.stream()
                .map(Step::isRightConnection)
                .collect(Collectors.toList()));
    }

    public Position ride(final Position position) {
        Step step = steps.get(position.getPosition());
        return step.step(position);
    }
}
