package ladder.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Ladder {
    private final List<Line> lines;

    public Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public List<String> asString() {
        return lines.stream()
                .map(Line::asString)
                .collect(Collectors.toList());
    }
}
