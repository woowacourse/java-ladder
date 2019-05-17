package ladder.domain.generator;

import ladder.domain.Line;

import java.util.ArrayList;
import java.util.List;

public class LineRandomGenerator implements LineGenerator {
    private final int countOfPlayers;
    private final int height;

    public LineRandomGenerator(int countOfPlayers, int height) {
        this.countOfPlayers = countOfPlayers;
        this.height = height;
    }

    @Override
    public List<Line> generate() {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(countOfPlayers));
        }
        return lines;
    }
}
