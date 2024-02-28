package domain;

import controller.LadderDto;

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

    public Lines lines() {
        return lines;
    }

    public Names names() {
        return names;
    }

    public Results results() {
        return results;
    }

    public LadderDto toDto() {
        return new LadderDto()
                .names(names)
                .lines(lines)
                .results(results)
                .build();
    }
}
