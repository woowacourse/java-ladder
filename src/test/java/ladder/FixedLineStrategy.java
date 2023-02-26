package ladder;

import ladder.domain.ladder.LineStrategy;
import ladder.domain.ladder.Step;

import java.util.List;
import java.util.stream.Collectors;

public class FixedLineStrategy implements LineStrategy {
    private final List<List<Boolean>> lines;
    private int generateCount;

    public FixedLineStrategy(List<List<Boolean>> lines) {
        this.lines = lines;
        this.generateCount = 0;
    }

    @Override
    public List<Step> generate(int sectionCount) {
        List<Step> line = lines.get(generateCount).stream()
                .map(Step::from)
                .collect(Collectors.toList());
        ++generateCount;
        return line;
    }
}
