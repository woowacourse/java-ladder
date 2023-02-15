package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {
    private final List<Line> ladder = new ArrayList<>();

    public void addLine(Line line) {
        ladder.add(line);
    }

    public List<Line> getLadder() {
        return ladder;
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
