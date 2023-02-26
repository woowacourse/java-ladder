package domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lines {

    private final List<Line> lines;

    public Lines(List<Line> lines) {
        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }

    public int getWidth() {
        return lines.get(0).size();
    }

    public Column move(Column column) {
        for (Line line : lines) {
            line.move(column);
        }
        return column;
    }

    public List<Line> getLines() {
        return lines.stream()
                .map(Line::new)
                .collect(Collectors.toUnmodifiableList());
    }
}
