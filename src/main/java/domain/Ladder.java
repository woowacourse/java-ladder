package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, Integer personCount, Height height) {
        List<RowLine> lines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(rowLineGenerator.generate(personCount));
        }
        return new Ladder(lines);
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }
}
