package domain;

import java.util.ArrayList;
import java.util.List;
import utils.booleanGenerator.BooleanGenerator;

public class Line {
    private final BooleanGenerator generator;

    List<Boolean> line;

    public Line(int lineSize, BooleanGenerator generator) {
        this.generator = generator;
        generateLine(lineSize);
    }

    public List<Boolean> getLine() {
        return List.copyOf(line);
    }

    private void generateLine(int lineSize) {
        line = new ArrayList<>();
        for (int index = 0; index < lineSize; index++) {
            line.add(getPoint(index));
        }
    }

    private boolean getPoint(int index) {
        if (isBeforePointTrue(index)) {
            return false;
        }
        return generator.generate();
    }

    private boolean isBeforePointTrue(int index) {
        return index > 0 && line.get(index - 1);
    }
}
