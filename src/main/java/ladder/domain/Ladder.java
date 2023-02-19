package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import ladder.util.BooleanGenerator;

public class Ladder implements Iterable<Line> {
    private List<Line> ladder;

    public Ladder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        do {
            ladder = new ArrayList<>();
            createLadder(numberOfPeople, ladderHeight, generator);
        } while (hasNoLine());
    }

    private boolean hasNoLine() {
        return ladder.stream().noneMatch(this::hasLine);
    }

    private boolean hasLine(Line line) {
        return line.getLine().stream().anyMatch(condition -> condition == Boolean.TRUE);
    }

    private void createLadder(int numberOfPeople, int ladderHeight, BooleanGenerator generator) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Line(numberOfPeople, generator));
        }
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }
}
