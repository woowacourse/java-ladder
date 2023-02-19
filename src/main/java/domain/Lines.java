package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import domain.generator.RandomConnectionGenerator;

public class Lines {

    private final List<Line> lines;

    public Lines(final int numberOfPlayer, final int height) {
        this.lines = makeLines(numberOfPlayer, height);
    }

    public Lines(final List<Line> lines) {
        this.lines = lines;
    }

    private List<Line> makeLines(final int numberOfPlayer, final int height) {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayer, new RandomConnectionGenerator()));
        }

        return lines;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.lines);
    }
}
