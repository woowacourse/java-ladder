package ladder.service;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

import ladder.domain.FootBars;
import ladder.domain.Ladder;
import ladder.domain.LadderHeight;
import ladder.domain.MatchResults;
import ladder.domain.Names;
import ladder.domain.Results;
import ladder.domain.SearchCompletionChecker;
import ladder.util.BooleanGenerator;

public class LadderService {
    private final BooleanGenerator generator;
    private Names names;
    private Results results;
    private LadderHeight ladderHeight;
    private Ladder ladder;
    private MatchResults matchResults;
    private SearchCompletionChecker checker;

    public LadderService(BooleanGenerator generator) {
        this.generator = generator;
    }

    public void readNames(List<String> names) {
        this.names = new Names(names);
    }

    public void readResults(List<String> results) {
        this.results = new Results(results, names.size());
    }

    public void readLadderHeight(int ladderHeight) {
        this.ladderHeight = new LadderHeight(ladderHeight);
    }

    public String createLadder() {
        ladder = new Ladder(Arrays.asList(new FootBars[ladderHeight.getLadderHeight()]));
        ladder.createLadder(names.size(), generator);
        return new LadderDrawer().draw(names, ladder, results);
    }

    public void matchNamesWithResults() {
        MatchResultCreator matchResultCreator = new MatchResultCreator(ladder, names, results);
        matchResults = matchResultCreator.createMatchResult();
        checker = new SearchCompletionChecker(matchResults.getMatchResults(), new LinkedHashMap<>());
    }

    public boolean isAllResultChecked() {
        return checker.isAllChecked();
    }

    public String findMatchResult(String nameWantToKnowResult) {
        return matchResults.findMatchResult(nameWantToKnowResult, checker);
    }
}
