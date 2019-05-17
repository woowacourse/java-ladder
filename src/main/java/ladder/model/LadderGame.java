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
            linkedStatus[i] = (int) (Math.random() * 2);
        }

        return linkedStatus;
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

    public EndResult excuteGame() {
        for (Row row : ladder) {
            for (int i = 0; i < row.getLineSize(); i++) {
                for (Member member : members) {
                    member.move(row.isLinked(i), i);
                }
            }
        }
        return makeResult();
    }

    private EndResult makeResult() {
        List<Result> finalResults = new ArrayList<>();

        for (Member member : members) {
            finalResults.add(new Result(results.get(member.getPosition()), member.getName()));
        }

        return new EndResult(finalResults);
    }
}
