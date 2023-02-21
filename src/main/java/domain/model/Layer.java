package domain.model;

import domain.type.Line;
import java.util.List;

public class Layer {

    private final List<Line> lines;
    private final PassGenerator passGenerator;

    public Layer(final List<Line> lines, final PassGenerator passGenerator) {
        this.lines = lines;
        this.passGenerator = passGenerator;
    }

    public void makeLine() {
        if (passGenerator.generate()
            && (lines.isEmpty() || lines.get(lines.size() - 1).equals(Line.UNCONNECTED))) {
            lines.add(Line.CONNECTED);
            return;
        }
        lines.add(Line.UNCONNECTED);
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}
