package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final LadderResults ladderResults;
    private final NamesCreator namesCreator = new NamesCreator();
    private final LadderResultCreator ladderResultCreator = new LadderResultCreator();

    public LadderGame(String userNames, String rawLadderResults, int ladderHeight, RowGenerator generator) {
        names = namesCreator.create(userNames);
        ladderResults = ladderResultCreator.create(rawLadderResults);
        Height height = new Height(ladderHeight);
        Width width = new Width(names.count());
        ladder = new Ladder(height, width, generator);
    }
    
    public LadderGameResult play() {
        LadderPositions ladderPositions = ladder.climbDown();
        return new LadderGameResult(names, ladderResults, ladder, ladderPositions);
    }
}
