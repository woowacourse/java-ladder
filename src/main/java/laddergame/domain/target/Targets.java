package laddergame.domain.target;

import laddergame.domain.move.LeftStrategy;
import laddergame.domain.move.MovableStrategy;
import laddergame.domain.move.Trace;

import java.util.List;

public class Targets {
    private List<Target> targets;

    public Targets(final List<String> input) {
        this.targets = convertToTargets(input);
    }

    public Target convertToTraceBy(final Trace trace) {
        int position = trace.getPosition();
        MovableStrategy movableStrategy = trace.getMovableStrategy();

        if (movableStrategy instanceof LeftStrategy) {
            return targets.get(position);
        }

        return targets.get(position + 1);
    }

    private List<laddergame.domain.target.Target> convertToTargets(final List<String> input) {
        return input.stream()
                .map(laddergame.domain.target.Target::new)
                .toList();
    }
}
