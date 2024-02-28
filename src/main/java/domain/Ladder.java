package controller;

import domain.Lines;
import domain.Names;
import domain.Results;

public class Ladder {
    private Lines lines;
    private Names names;
    private Results results;

    public Ladder lines(final Lines lines) {
        this.lines = lines;
        return this;
    }

    public Ladder names(final Names names) {
        this.names = names;
        return this;
    }

    public Ladder results(final Results results) {
        this.results = results;
        return this;
    }

    public Ladder build() {
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
