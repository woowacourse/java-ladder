package factory;

import domain.Ladder;
import domain.Line;
import domain.PointGenerateStrategy;
import domain.RandomBasedStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderFactory {

    public static Ladder of(
            final int playersSize,
            final int ladderHeight,
            final PointGenerateStrategy pointGenerateStrategy
    ) {
        return new Ladder(generateLines(playersSize, ladderHeight, pointGenerateStrategy));
    }

    private static List<Line> generateLines(
            final int playerSize,
            final int ladderHeight,
            final PointGenerateStrategy pointGenerateStrategy
    ) {
        List<Line> lines = new ArrayList<>();
        int pointSize = playerSize - 1;
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            lines.add(LineFactory.of(pointSize, pointGenerateStrategy));
        }
        return Collections.unmodifiableList(lines);
    }

}
