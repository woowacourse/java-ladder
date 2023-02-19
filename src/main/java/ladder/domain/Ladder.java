package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(List<Line> lines) {
        this.lines = lines;
    }

    public static Ladder of(int playerCount, int height) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(Line.of(new RandomStepPointGenerator(), playerCount - 1));
        }
        return new Ladder(lines);
    }

    public List<Line> toUnModifiableLines() {
        return List.copyOf(lines);
    }
}
