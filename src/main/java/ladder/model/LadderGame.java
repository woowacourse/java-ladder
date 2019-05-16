package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final List<Row> ladder = new ArrayList<>();
    private final List<Member> members;
    private final List<String> results;

    public LadderGame(List<Member> members, int ladderHeight, List<String> results) {
        this.members = members;
        this.results = results;

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(members.size()));
        }
    }

    public List<Row> getLadder() {
        return ladder;
    }

    public List<Member> getMembers() {
        return members;
    }

    public List<String> getResults() {
        return results;
    }

    public int getLadderHeight() {
        return ladder.size();
    }
}
