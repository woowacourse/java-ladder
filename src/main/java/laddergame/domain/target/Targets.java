package laddergame.domain.target;

import java.util.List;

public class Targets {
    private List<Target> targets;

    public Targets(final List<String> input) {
        this.targets = convertToTargets(input);
    }

    private List<Target> convertToTargets(final List<String> input) {
        return input.stream()
                .map(Target::new)
                .toList();
    }
}
