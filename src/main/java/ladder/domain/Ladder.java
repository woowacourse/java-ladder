package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Ladder implements Iterable<Line> {
    private final List<Line> ladder;

    public Ladder(int personCount, int height, BooleanGenerator generator) {
        ladder = new ArrayList<>();
        createLadder(personCount, height, generator);
    }

    private void createLadder(int personCount, int height, BooleanGenerator generator) {
        for (int i = 0; i < height; i++) {
            addLine(new Line(personCount, generator));
        }
    }

    private void addLine(Line line) {
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
