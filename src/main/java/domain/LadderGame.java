package domain;

import java.util.Map;

import domain.generator.RandomConnectionGenerator;

public class LadderGame {

    private final Names names;
    private final Results results;

    public LadderGame(final Names names, final Results results) {
        this.names = names;
        this.results = results;
    }

    public Ladder createLadder(final int height) {
        return new Ladder(names.getNames().size(), height, new RandomConnectionGenerator());
    }

    public GameResult createResult(final Ladder ladder) {
        Map<String, String> gameResult = ladder.matchResult(names.getNames(), results.getResults());
        return new GameResult(gameResult);
    }

    public Names getNames() {
        return this.names;
    }

    public Results getResults() {
        return this.results;
    }
}
