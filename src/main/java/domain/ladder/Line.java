package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.RandomBooleanGenerator;

public class Line {
    private final List<Boolean> line;
    private final RandomBooleanGenerator randomNumberGenerator = new RandomBooleanGenerator();

    public Line(int personCount) {
        this.line = createLine(personCount);
    }

    private List<Boolean> createLine(int personCount) {
        List<Boolean> line = new ArrayList<>();
        line.add(false);
        for (int i = 1; i < personCount; i++) {
            line.add(isContinuousTrue(line, i));
        }
        return line;
    }

    private boolean isContinuousTrue(List<Boolean> line, int index) {
        if (line.get(index - 1)) {
            return false;
        }
        return randomNumberGenerator.isMovable();
    }

    public List<Boolean> getLine() {
        return line;
    }
}
