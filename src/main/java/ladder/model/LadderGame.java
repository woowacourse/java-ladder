package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class LadderGame {
    private static final int MAX_BOUNDARY = 2;
    private final List<Row> ladder = new ArrayList<>();
    private final List<Member> members;
    private final List<String> results;

    public LadderGame(List<Member> members, int ladderHeight, List<String> results) {
        this.members = members;
        this.results = results;

        for (int i = 0; i < ladderHeight; i++) {
            ladder.add(new Row(linkedStatusGenerator(members.size())));
        }
    }

    public LadderGame(List<Member> members, int[][] linkedStatus, List<String> results) {
        this.members = members;
        this.results = results;

        for (int[] status : linkedStatus) {
            ladder.add(new Row(status));
        }
    }

    private int[] linkedStatusGenerator(int countOfMembers) {
        int[] linkedStatus = new int[countOfMembers - 1];

        for (int i = 0; i < linkedStatus.length; i++) {
            linkedStatus[i] = (int) (Math.random() * MAX_BOUNDARY);
        }

        return linkedStatus;
    }

    public EndResult executeGame() {
        ladder.forEach(row -> members.forEach(member -> member.move(row.move(member.getPosition()))));
        return makeResult();
    }

    private EndResult makeResult() {
        List<Result> finalResults = new ArrayList<>();

        for (Member member : members) {
            finalResults.add(new Result(results.get(member.getPosition()), member.getName()));
        }

        return new EndResult(finalResults);
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
