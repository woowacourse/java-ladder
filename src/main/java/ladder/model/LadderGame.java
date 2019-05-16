package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final List<Row> ladder = new ArrayList<>();
    private final List<Member> members;

    public LadderGame(List<Member> members, int ladderHeight) {
        this.members = members;
        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(members.size()));
        }
    }

    public int getLadderHeight() {
        return ladder.size();
    }
}
