package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    List<Row> ladder = new ArrayList<>();
    List<Member> members;

    public LadderGame(String[] names, int ladderHeight) {
        members = Members.generateMembers(names);

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(members.size()));
        }
    }


    public int getLadderHeight() {
        return ladder.size();
    }
}
