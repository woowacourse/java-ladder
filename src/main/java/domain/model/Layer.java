package domain.model;

import java.util.ArrayList;
import java.util.List;

public class Layer {

    private final List<Boolean> lines = new ArrayList<>();

    public void makeLine(final boolean condition) {
        if (condition && lines.isEmpty()) {
            lines.add(true);
            return;
        }
        if (condition && !lines.get(lines.size() - 1)) {
            lines.add(true);
            return;
        }
        lines.add(false);
    }

    public List<Boolean> getLines() {
        return List.copyOf(lines);
    }

    public boolean getLine(final int index) {
        return lines.get(index);
    }
}
