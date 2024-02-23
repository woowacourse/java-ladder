package util;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderSequence {

    private LadderSequence() {}

    public static List<String> from(Ladder ladder) {
        Iterator<Line> iterator = ladder.iterator();
        List<String> ladderSequence = new ArrayList<>();
        while (iterator.hasNext()) {
            ladderSequence.add(getLineSequence(iterator.next()));
        }
        return ladderSequence;
    }

    private static String getLineSequence(Line line) {
        Iterator<Connection> iterator = line.iterator();
        StringBuilder stringBuilder = new StringBuilder();
        while (iterator.hasNext()) {
            stringBuilder.append(iterator.next().getBridge());
        }
        return stringBuilder.toString();
    }
}
