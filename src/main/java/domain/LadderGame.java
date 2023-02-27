package domain;

import java.util.List;
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

    public Map<String, String> createResult(final Ladder ladder) {
        return ladder.matchResult(names.getNames(), results.getResults());
    }

    public List<Name> getNames() {
        return this.names.getNames();
    }

    public List<Result> getResults() {
        return this.results.getResults();
    }
}
