package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final LadderResults ladderResults;

    public LadderGame(String userNames, String rawLadderResults, int ladderHeight, BridgesGenerator generator) {
        NamesCreator namesCreator = new NamesCreator();
        LadderResultCreator ladderResultCreator = new LadderResultCreator();
        names = namesCreator.create(userNames);
        ladderResults = ladderResultCreator.create(rawLadderResults);
        int nameCount = names.count();
        Height height = new Height(ladderHeight);
        Width width = new Width(nameCount);
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
