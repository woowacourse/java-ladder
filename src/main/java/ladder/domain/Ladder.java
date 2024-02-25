package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public record Ladder(List<Line> lines) {
    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    @Override
    public List<Line> lines() {
        return List.copyOf(lines);
    }
}
