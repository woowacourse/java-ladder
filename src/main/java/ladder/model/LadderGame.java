package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {
    private final Members members;
    private final List<String> results;
    private final Ladder ladder;

    public LadderGame(Members members, int ladderHeight, List<String> results) {
        this.members = members;
        this.results = results;
        this.ladder = new Ladder(ladderHeight, members.size());
    }

    public EndResult execute() {
        members.move(ladder.getLadder());
        return makeResult();
    }

    private EndResult makeResult() {
        Map<String, Result> endResult = new HashMap<>();
        for (Member member : members.getMembers()) {
            String winner = member.getName();
            Result result = new Result(results.get(member.getPosition()), winner);
            endResult.put(winner, result);
        }
        return new EndResult(endResult);
    }

    public List<Member> getMembers() {
        return members.getMembers();
    }

    public List<String> getResults() {
        return results;
    }

    public Ladder getLadder() {
        return ladder;
    }
}
