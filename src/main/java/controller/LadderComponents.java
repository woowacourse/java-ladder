package controller;

import domain.Lines;
import domain.Names;
import domain.Results;

public class LadderComponents {
    private Lines lines;
    private Names names;
    private Results results;

    public LadderComponents lines(final Lines lines) {
        this.lines = lines;
        return this;
    }

    public LadderComponents names(final Names names) {
        this.names = names;
        return this;
    }

    public LadderComponents results(final Results results) {
        this.results = results;
        return this;
    }

    public LadderComponents build() {
        return this;
    }

    public Lines getLines() {
        return lines;
    }

    public Names getNames() {
        return names;
    }

    public Results getResults() {
        return results;
    }
}
