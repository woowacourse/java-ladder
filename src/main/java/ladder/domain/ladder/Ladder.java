package ladder.domain.ladder;

import ladder.domain.linegenerator.LineGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {
    private final List<Line> lines;

    public Ladder(LineGenerator lineGenerator, Height height) {
        lines = new ArrayList<>();
        addLines(lineGenerator, height);
    }

    private void addLines(LineGenerator lineGenerator, Height height) {
        for (int i = 0; i < height.getHeight(); i++) {
            lines.add(lineGenerator.generateLine());
        }
    }

    public int getHeight() {
        return lines.size();
    }

    public Line get(int index) {
        return lines.get(index);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
