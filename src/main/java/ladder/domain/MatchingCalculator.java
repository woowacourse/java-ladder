package ladder.domain;

import java.util.HashMap;
import java.util.List;

public class MatchingCalculator {
    private final Ladder ladder;
    private final Names names;
    private final Results results;
    private final HashMap<Name, Result> matchings;

    public MatchingCalculator(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
        this.matchings = new HashMap<>();
    }

    private void climbDown(List<Name> participants, List<Boolean> conditions) {
        for (int i = 0; i < conditions.size(); i++) {
            swap(participants, conditions, i);
        }
    }

    private void swap(List<Name> participants, List<Boolean> conditions, int i) {
        if (conditions.get(i)) {
            Name temp = participants.get(i);
            participants.set(i, participants.get(i + 1));
            participants.set(i + 1, temp);
        }
    }

    public HashMap<Name, Result> getMatchings() {
        return matchings;
    }

    public void calculate() {
        List<Name> participants = names.getNames();
        for (Line line : ladder) {
            List<Boolean> conditions = line.getLine();
            climbDown(participants, conditions);
        }
        match(participants);
    }

    private void match(List<Name> participants) {
        for (int i = 0; i < participants.size(); i++) {
            matchings.put(participants.get(i), results.getResults().get(i));
        }
    }

}
