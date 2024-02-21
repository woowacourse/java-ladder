package ladder.domain;

import ladder.util.RandomBooleanListGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Ladder {

    private final List<Line> lines;


    public Ladder(int height, int personCount) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(personCount, new RandomBooleanListGenerator()));
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
