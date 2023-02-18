package factory;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LadderFactory {

    public static Ladder of(final int playersSize, final int ladderHeight) {
        return new Ladder(generateLines(playersSize, ladderHeight));
    }

    private static List<Line> generateLines(final int playersSize, final int ladderHeight) {
        List<Line> lines = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < ladderHeight; lineIndex++) {
            int pointNum = playersSize - 1;
            lines.add(new Line(pointNum));
        }
        return lines;
    }

}
