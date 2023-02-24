package domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Layer {

    private final List<Boolean> lines;

    public Layer() {
        this.lines = new ArrayList<>();
    }

    public void makeLine(final boolean condition) {
        if (isLinesEmpeyOrLastLine(condition)) {
            lines.add(true);
            return;
        }
        lines.add(false);
    }

    private boolean isLinesEmpeyOrLastLine(boolean condition) {
        return condition && (lines.isEmpty() || !lines.get(lines.size() - 1));
    }

    public List<Boolean> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
