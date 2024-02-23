package domain;

import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private final List<RowLine> lines;

    private Ladder(List<RowLine> lines) {
        this.lines = lines;
    }

    public static Ladder createFrom(RowLineGenerator rowLineGenerator, int personCount, Height height) {
        List<RowLine> lines = IntStream.range(0, height.getHeight())
                .mapToObj(i -> rowLineGenerator.generate(personCount))
                .toList();
        return new Ladder(lines);
    }

    public List<RowLine> getLines() {
        return List.copyOf(lines);
    }
}
