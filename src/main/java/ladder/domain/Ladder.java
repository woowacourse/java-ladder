package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Ladder implements Iterable<Line> {
    private final List<Line> ladder;

    public Ladder() {
        ladder = new ArrayList<>();
    }

    public void drawLine(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        do {
            createLadder(numberOfPeople, ladderHeight, generator);
        } while (hasNoLine());
    }

    private void createLadder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        ladder.clear();
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(numberOfPeople, generator));
        }
    }

    private boolean hasNoLine() {
        return ladder.stream().noneMatch(this::hasLine);
    }

    private boolean hasLine(Line line) {
        return line.getLine().stream().anyMatch(condition -> condition == Boolean.TRUE);
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
