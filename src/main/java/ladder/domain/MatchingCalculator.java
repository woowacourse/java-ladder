package ladder.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class MatchingCalculator {
    private final Ladder ladder;
    private final Names names;
    private final Results results;
    private Matchings matchings;

    public MatchingCalculator(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public Matchings calculate() {
        List<Name> participants = new ArrayList<>(names.getNames());

        climbDown(participants);
        match(participants);
        return matchings;
    }

    private void climbDown(List<Name> participants) {
        for (Line line : ladder) {
            List<Boolean> conditions = line.getLine();
            swapNames(participants, conditions);
        }
    }

    private void swapNames(List<Name> participants, List<Boolean> conditions) {
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

    private void match(List<Name> participants) {
        HashMap<Name, Result> matchingResult = matchResult(participants);

        LinkedHashMap<Name, Result> orderedMatchingResult = sortByInputOrder(matchingResult);

        matchings = new Matchings(orderedMatchingResult);
    }

    private HashMap<Name, Result> matchResult(List<Name> participants) {
        HashMap<Name, Result> matchingResult = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            matchingResult.put(participants.get(i), results.getResults().get(i));
        }
        return matchingResult;
    }

    private LinkedHashMap<Name, Result> sortByInputOrder(HashMap<Name, Result> matchingResult) {
        LinkedHashMap<Name, Result> orderedMatchingResult = new LinkedHashMap<>();

        for (Name name : names.getNames()) {
            orderedMatchingResult.put(name, matchingResult.get(name));
        }
        return orderedMatchingResult;
    }

}
