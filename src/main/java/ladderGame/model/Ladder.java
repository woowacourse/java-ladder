package ladderGame.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int maxHeight, int personNumber) {
        LineGenerator lineGenerator = new LineGenerator(new RandomBooleanGenerator());
        lines = Stream.generate(() -> new Line(lineGenerator.makeLine(personNumber)))
                .limit(maxHeight)
                .toList();
    }

    public List<Line> getLines() {
        return new ArrayList<>(lines);
    }
}
