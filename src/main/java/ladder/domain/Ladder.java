package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Ladder implements Iterable<Line> {
    private final List<Line> ladder;

    public Ladder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        ladder = new ArrayList<>();
        createLadder(numberOfPeople, ladderHeight, generator);
    }

    private void createLadder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        for (int i = 0; i < ladderHeight; i++) {
            addLine(new Line(numberOfPeople, generator));
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
