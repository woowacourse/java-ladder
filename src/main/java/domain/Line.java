package domain;

import java.util.ArrayList;
import java.util.List;
import utils.BooleanGenerator;

public class Line {
    private static final int PERSON_NUMBER_LINE_SIZE_DIFFERENCE = 1;

    private final BooleanGenerator generator;
    private final List<Boolean> line = new ArrayList<>();

    public Line(int personNumber, BooleanGenerator generator) {
        this.generator = generator;
        generateLine(personNumber);
    }

    public List<Boolean> getLine() {
        return List.copyOf(line);
    }

    public int getLineSize() {
        return line.size();
    }

    private void generateLine(int personNumber) {
        for (int index = 0; index < personNumber - PERSON_NUMBER_LINE_SIZE_DIFFERENCE; index++) {
            line.add(getPoint(index));
        }
    }

    private boolean getPoint(int index) {
        if (isAbleTrue(index)) {
            return false;
        }
        return generator.generate();
    }

    private boolean isAbleTrue(int index) {
        return index > 0 && line.get(index - 1);
    }
}
