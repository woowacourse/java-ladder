package ladder;

import ladder.utils.LineStrategy;

import java.util.List;

public class FixedLineStrategy implements LineStrategy {
    private final List<Boolean> line;

    public FixedLineStrategy(List<Boolean> line) {
        this.line = line;
    }

    @Override
    public List<Boolean> generate(int lineLength) {
        return line;
    }
}
