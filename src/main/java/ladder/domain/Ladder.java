package ladder.domain;

import ladder.util.BooleanListGenerator;
import ladder.util.RandomBooleanListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;


    public Ladder(int height, int personCount) {
        BooleanListGenerator booleanListGenerator = new RandomBooleanListGenerator();

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, booleanListGenerator));
        }
        this.lines = lines;
    }

    public List<Line> getLines() {
        return lines;
    }

    @Override
    public String toString() {
        return lines.stream()
                .map(Line::toString)
                .collect(Collectors.joining("\n"));
    }
}
