package laddergame.domain.target;

import laddergame.domain.result.Trace;

import java.util.List;

public class Targets {
    private List<Target> targets;

    public Targets(final List<String> input) {
        this.targets = convertToTargets(input);
    }

    public Target convertToTarget(final Trace trace) {
        int position = trace.getPosition();

        return targets.get(position);
    }

    public List<Target> getTargets() {
        return targets;
    }

    private List<laddergame.domain.target.Target> convertToTargets(final List<String> input) {
        return input.stream()
                .map(laddergame.domain.target.Target::new)
                .toList();
    }
}
