package ladder.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class Matcher {
    private final Ladder ladder;
    private final Names names;
    private final Results results;
    private MatchResults matchResults;

    public Matcher(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public MatchResults match() {
        List<Name> participants = new ArrayList<>(names.getNames());

        climbDown(participants);
        match(participants);
        return matchResults;
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
            Collections.swap(participants, i, i + 1);
        }
    }

    private void match(List<Name> participants) {
        HashMap<Name, Result> matchResult = matchResult(participants);

        LinkedHashMap<Name, Result> orderedMatchResult = sortByInputOrder(matchResult);

        matchResults = new MatchResults(orderedMatchResult);
    }

    private HashMap<Name, Result> matchResult(List<Name> participants) {
        HashMap<Name, Result> matchResult = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            matchResult.put(participants.get(i), results.getResults().get(i));
        }
        return matchResult;
    }

    private LinkedHashMap<Name, Result> sortByInputOrder(HashMap<Name, Result> matchResult) {
        LinkedHashMap<Name, Result> orderedMatchResult = new LinkedHashMap<>();

        for (Name name : names.getNames()) {
            orderedMatchResult.put(name, matchResult.get(name));
        }
        return orderedMatchResult;
    }

}
