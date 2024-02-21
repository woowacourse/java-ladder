package laddergame.domain;

public class LadderGame {

    private final Names names;
    private Ladder ladder;

    private LadderGame(final Names names, final Ladder ladder) {
        this.names = names;
        this.ladder = ladder;
    }

    public static LadderGame create(final Names names, final LadderHeight height, final BooleanGenerator booleanGenerator) {
        final Ladder ladder = Ladder.create(calculateLineSize(names), height, booleanGenerator);
        return new LadderGame(names, ladder);
    }

    private static int calculateLineSize(final Names names) {
        return names.size() - 1;
    }

    public Result getResult() {
        return new Result(names.getNames(), ladder.getLines());
    }
}
