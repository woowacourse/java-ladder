package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private final Members members;
    private final List<String> results;
    private final Ladder ladder;

    public LadderGame(Members members, int ladderHeight, List<String> results) {
        this.members = members;
        this.results = results;
        this.ladder = new Ladder(ladderHeight, members.size());
    }

    public EndResult excute() {
        members.move(ladder.getLadder());
        return makeResult();
    }

    private EndResult makeResult() {
        List<Result> endResult = new ArrayList<>();

        for (Member member : members.getMembers()) {
            Result result = new Result(results.get(member.getPosition()), member.getName());
            endResult.add(result);
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
