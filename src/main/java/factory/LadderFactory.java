package factory;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LadderFactory {

    public static Ladder of(final int playersSize, final int ladderHeight) {
        return new Ladder(generateLines(playersSize, ladderHeight));
    }

    private static List<Line> generateLines(final int playerSize, final int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        int pointSize = playerSize - 1;
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            lines.add(LineFactory.of(pointSize));
        }
        return Collections.unmodifiableList(lines);
    }

}
