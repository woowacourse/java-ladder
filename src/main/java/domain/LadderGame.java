package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final LadderResults ladderResults;

    public LadderGame(Ladder ladder, Names names, LadderResults ladderResults) {
        validateCountEqual(ladder, names, ladderResults);
        this.ladder = ladder;
        this.names = names;
        this.ladderResults = ladderResults;
    }

    public LadderResult drive(String name) {
        return ladderResults.get(ladder.drive(names.indexOf(name)));
    }

    private void validateCountEqual(Ladder ladder, Names names, LadderResults ladderResults) {
        if (ladder.getColumnCount() != ladderResults.getResultCount()) {
            throw new IllegalArgumentException("[ERROR] 사다리 열과 결과의 개수가 일치하지 않습니다");
        }
    }
}
