package ladder.model;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
            endResult.put(member.getName(), result);
        });
        return endResult;
    }

    public List<String> getMembersName() {
        return members.allMembers()
                .stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public List<String> getResults() {
        return results.getResults()
                .stream()
                .map(Result::getResult)
                .collect(Collectors.toList());
    }

    public List<Row> getLadderStructure() {
        return ladder.ladderStructure();
    }
}
