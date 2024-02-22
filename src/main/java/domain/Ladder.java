package domain;

import domain.point.strategy.RandomBridgeGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(LadderHeight height, int pointCount) {
        RandomBridgeGenerator randomPointGenerator = new RandomBridgeGenerator();

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height.getValue(); i++) {
            List<LadderBridge> bridges = randomPointGenerator.generate(pointCount);
            lines.add(new Line(bridges));
        }

        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
