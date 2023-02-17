package domain.model;

import domain.type.Line;
import java.util.ArrayList;
import java.util.List;

public class Layer {

    private final List<Line> lines;

    public Layer() {
        this.lines = new ArrayList<>();
    }

    public void makeLine(final Line line) {
        if (line.equals(Line.CONNECTED) && lines.isEmpty()) {
            lines.add(line);
            return;
        }
        if (line.equals(Line.CONNECTED) && !lines.get(lines.size() - 1).equals(Line.UNCONNECTED)) {
            lines.add(line);
            return;
        }
        lines.add(Line.UNCONNECTED);
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
