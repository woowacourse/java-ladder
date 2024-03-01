package controller;

import domain.Line;
import domain.Lines;
import domain.Names;
import domain.Results;
import java.util.List;

public class LadderDto {
    private List<String> names;
    private List<Line> lines;
    private List<String> results;

    public LadderDto names(final Names names) {
        this.names = names.getAll();
        return this;
    }

    public LadderDto lines(final Lines lines) {
        this.lines = lines.getLines();
        return this;
    }

    public LadderDto results(final Results results) {
        this.results = results.getAll();
        return this;
    }

    public LadderDto build() {
        return this;
    }

    public List<String> getNames() {
        return names;
    }

    public List<Line> getLines() {
        return lines;
    }

    public List<String> getResults() {
        return results;
    }
}
