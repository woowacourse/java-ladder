package ladder.domain.resource.ladder;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;

public class LadderGenerator {

    private final LineGenerator lineGenerator;

    public LadderGenerator(LineGenerator lineGenerator) {
        this.lineGenerator = lineGenerator;
    }

    public Ladder generate(int height, int width) {
        List<Line> lines = generateLines(height, width);
        return new Ladder(lines);
    }

    private List<Line> generateLines(int height, int width) {
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.generateLine(width));
        }

        return lines;
    }
}
