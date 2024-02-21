package util;

import domain.Ladder;
import domain.Line;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LadderString {

    private LadderString() {}

    public static List<String> from(Ladder ladder) {
        Iterator<Line> iterator = ladder.iterator();
        List<String> ladderString = new ArrayList<>();
        while (iterator.hasNext()) {
            ladderString.add(LineString.from(iterator.next()));
        }
        return ladderString;
    }
}
