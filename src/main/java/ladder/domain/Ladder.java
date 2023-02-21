package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final List<Line> lines) {
        this.lines = lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
