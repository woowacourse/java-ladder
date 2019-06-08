package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int MAX_BOUNDARY = 2;
    private final List<Row> ladder = new ArrayList<>();

    public Ladder(int ladderHeight, int countOfMembers) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(linkedStatusGenerator(countOfMembers)));
        }
    }

    private List<Integer> linkedStatusGenerator(int countOfMembers) {
        List<Integer> linkedStatus = new ArrayList<>();

        for (int i = 0; i < countOfMembers; i++) {
            linkedStatus.add((int) (Math.random() * MAX_BOUNDARY));
        }

        return linkedStatus;
    }

    public List<Row> getLadder() {
        return ladder;
    }

    public int ladderHeight() {
        return ladder.size();
    }
}
