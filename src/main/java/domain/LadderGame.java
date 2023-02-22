package domain;

public class LadderGame {
    private final Ladder ladder;
    private final Names names;
    private final Results results;

    public LadderGame(Ladder ladder, Names names, Results results) {
        this.ladder = ladder;
        this.names = names;
        this.results = results;
    }

    public Result getResultOf(String inputName) {
        int startPosition = names.getPositionOf(inputName);
        int resultPosition = ladder.getResultPositionOf(startPosition);
        return results.get(resultPosition);
    }

}
