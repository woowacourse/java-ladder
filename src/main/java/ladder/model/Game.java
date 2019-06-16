package ladder.model;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private final List<String> names;
    private final List<String> outcomes;
    private final List<String> result;
    private final Ladder ladder;

    public Game(List<String> names, List<String> outcomes, int ladderHeight) {
        this.names = names;
        this.outcomes = outcomes;
        this.ladder = LadderFactory.createLadder(names.size(), ladderHeight);
        this.result = mapOutcomes(outcomes, ladder.play());
    }

    private static List<String> mapOutcomes(List<String> outcomes, LadderResult result) {
        List<String> after = new ArrayList<>(outcomes);
        for (int i = 0; i < outcomes.size(); i++) {
            after.set(i, outcomes.get(result.getTarget(i)));
        }
        return after;
    }

    public List<String> getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public List<String> getOutcomes() {
        return outcomes;
    }

    public List<String> getResults() {
        return result;
    }
}
