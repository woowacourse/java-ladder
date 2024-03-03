package domain;

import domain.ladder.BridgeGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderCreator;
import domain.ladder.LadderPositions;
import domain.name.Name;
import domain.name.Names;
import domain.name.NamesCreator;
import domain.result.Result;
import domain.result.Results;
import domain.result.ResultsCreator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
        Map<Name, Result> ladderGameResult = mapNamesLadderResults(names, results, ladderPositions);
        return new LadderGameResult(names, results, ladder, ladderGameResult);
    }

    private Map<Name, Result> mapNamesLadderResults(Names names, Results results,
                                                    LadderPositions ladderPositions) {
        return IntStream.range(0, names.count())
                .boxed()
                .collect(Collectors.toMap(
                        index -> names.getNames().get(ladderPositions.getPosition(index)),
                        index -> results.getLadderResults().get(index)));

    }
}

