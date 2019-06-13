package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Row> ladder = new ArrayList<>();

    Ladder(int ladderHeight, int countOfMembers) {
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(countOfMembers));
        }
    }

    public List<Row> getLadder() {
        return ladder;
    }

    public int ladderHeight() {
        return ladder.size();
    }
}
