package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = new ArrayList<>(lines);
    }

    public List<List<Boolean>> getScaffolds() {
        return lines.stream()
                .map(Line::getScaffold)
                .toList();
    }
}
