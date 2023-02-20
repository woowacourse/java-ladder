package factory;

import domain.Ladder;
import domain.Line;
import domain.RandomBasedStrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderFactory {

    public static Ladder generate(
            final int playersSize,
            final int ladderHeight,
            final RandomBasedStrategy randomBasedStrategy
    ) {
        return new Ladder(generateLines(playersSize, ladderHeight, randomBasedStrategy));
    }

    private static List<Line> generateLines(
            final int playerSize,
            final int ladderHeight,
            final RandomBasedStrategy randomBasedStrategy
    ) {
        List<Line> lines = new ArrayList<>();
        int pointSize = playerSize - 1;
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            lines.add(LineFactory.generate(pointSize, randomBasedStrategy));
        }
        return Collections.unmodifiableList(lines);
    }

}
