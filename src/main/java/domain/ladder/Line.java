package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Line {
    private final List<Boolean> line;

    public Line(int width, BooleanGenerator booleanGenerator) {
        this.line = createLine(width, booleanGenerator);
    }

    private List<Boolean> createLine(int width, BooleanGenerator booleanGenerator) {
        List<Boolean> line = new ArrayList<>();
        line.add(false);
        for (int i = 1; i < width; i++) {
            line.add(isContinuousTrue(line.get(i - 1), booleanGenerator));
        }
        return line;
    }

    private boolean isContinuousTrue(boolean lastStatus, BooleanGenerator booleanGenerator) {
        if (lastStatus) {
            return false;
        }
        return booleanGenerator.isMovable();
    }

    public List<Boolean> getLine() {
        return line;
    }
}
