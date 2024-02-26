package laddergame.domain.strategy;

import laddergame.domain.Line;
import laddergame.util.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class LinesBuilder {
    private final LineGenerator lineGenerator;

    public LinesBuilder(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public List<Line> build(final int width) {
        List<Line> lineStatus = new ArrayList<>();

        lineStatus.add(lineGenerator.generate());
        for (int i = 0; i < width - 1; i++) {
            Line beforeValue = lineStatus.get(lineStatus.size() -1);
            lineStatus.add(decideNextValue(beforeValue));
        }
        return lineStatus;
    }

    private Line decideNextValue(Line beforeValue) {
        if (beforeValue.equals(Line.BRIDGE)) {
            return Line.EMPTY;
        }
        return lineGenerator.generate();
    }
}

