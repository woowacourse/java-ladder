package domain;

import domain.ladder.BridgeGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.ladder.LadderPositions;
import domain.name.Names;
import domain.name.NamesCreator;
import domain.result.Results;
import domain.result.ResultsCreator;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final Results results;
    private final NamesCreator namesCreator = new NamesCreator();
    private final ResultsCreator resultsCreator = new ResultsCreator();
    private final LadderCreator ladderCreator = new LadderCreator();

    public LadderGame(String userNames, String rawLadderResults, int ladderHeight, BridgeGenerator generator) {
        names = namesCreator.create(userNames);
        results = resultsCreator.create(rawLadderResults);
        ladder = ladderCreator.create(ladderHeight, names.count(), generator);
    }

    public LadderGameResult play() {
        LadderPositions ladderPositions = ladder.goDown();
        return new LadderGameResult(names, results, ladder, ladderPositions);
    }
}
