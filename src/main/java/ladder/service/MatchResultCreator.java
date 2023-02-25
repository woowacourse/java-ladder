package ladder.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import ladder.domain.FootBars;
import ladder.domain.Ladder;
import ladder.domain.MatchResults;
import ladder.domain.Name;
import ladder.domain.Names;
import ladder.domain.Result;
import ladder.domain.Results;

public class MatchResultCreator {
    private final Ladder ladder;
    private final Names names;
    private final Results results;
    private MatchResults matchResults;

    public MatchResultCreator(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public MatchResults createMatchResult() {
        List<Name> participants = new ArrayList<>(names.getNames());

        climbDown(participants);
        match(participants);
        return matchResults;
    }

    private void climbDown(List<Name> participants) {
        for (FootBars footBars : ladder.getLadder()) {
            swapNames(participants, footBars.getFootBars());
        }
    }

    private void swapNames(List<Name> participants, List<Boolean> footBars) {
        for (int i = 0; i < footBars.size(); i++) {
            swap(participants, footBars, i);
        }
    }

    private void swap(List<Name> participants, List<Boolean> conditions, int i) {
        if (conditions.get(i)) {
            Collections.swap(participants, i, i + 1);
        }
    }

    private void match(List<Name> participants) {
        HashMap<Name, Result> matchResult = matchResult(participants);

        LinkedHashMap<Name, Result> orderedMatchResult = orderMatchResultByInput(matchResult);

        matchResults = new MatchResults(Collections.unmodifiableMap(orderedMatchResult));
    }

    private HashMap<Name, Result> matchResult(List<Name> participants) {
        HashMap<Name, Result> matchResult = new HashMap<>();

        for (int i = 0; i < participants.size(); i++) {
            matchResult.put(participants.get(i), results.getResults().get(i));
        }
        return matchResult;
    }

    private LinkedHashMap<Name, Result> orderMatchResultByInput(HashMap<Name, Result> matchResult) {
        LinkedHashMap<Name, Result> orderedMatchResult = new LinkedHashMap<>();

        for (Name name : names.getNames()) {
            orderedMatchResult.put(name, matchResult.get(name));
        }
        return orderedMatchResult;
    }

}
