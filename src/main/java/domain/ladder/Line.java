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
            line.add(isContinuousTrue(line.get(i - 1)));
        }
        return line;
    }

    private boolean isContinuousTrue(boolean lastStatus) {
        if (lastStatus) {
            return false;
        }
        return randomNumberGenerator.isMovable();
    }

    public List<Boolean> getLine() {
        return line;
    }
}
