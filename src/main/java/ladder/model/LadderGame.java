package ladder.model;

import java.util.HashMap;

public class LadderGame {
    private final Members members;
    private final Ladder ladder;
    private final DefaultResults results;

    public LadderGame(Members members, Ladder ladder, DefaultResults results) {
        this.members = members;
        this.ladder = ladder;
        this.results = results;
    }

    public EndResult executeGame() {
        EndResult endResult = new EndResult(new HashMap<>());
        members.allMembers().forEach(member -> {
            Result result = ladder.play(member, results);
            endResult.put(member, result);
        });
        return endResult;
    }
}
