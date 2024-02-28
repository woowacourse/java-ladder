package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final LadderResults ladderResults;
    private final NamesCreator namesCreator = new NamesCreator();
    private final LadderResultCreator ladderResultCreator = new LadderResultCreator();

    public LadderGame(String userNames, String rawLadderResults, int ladderHeight, BridgesGenerator generator) {
        names = namesCreator.create(userNames);
        ladderResults = ladderResultCreator.create(rawLadderResults);
        Height height = new Height(ladderHeight);
        Width width = new Width(names.count());
        ladder = new Ladder(height, width, generator);
    }

    public Names getNames() {
        return names;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public LadderResults getLadderResults() {
        return ladderResults;
    }

    public LadderGameResult calculateLadderGameResult() {
        return new LadderGameResult(names, ladderResults, ladder);
    }
}
