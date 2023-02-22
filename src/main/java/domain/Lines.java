package domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    
    private final List<Line> lines;

    public Lines(int personCount, int height) {
        validateLadderHeight(height);
        this.lines = createLines(personCount, height);
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 최소 높이는 1이상이어야 합니다.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    private List<Line> createLines(int personCount, int height) {
        List<Line> lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount));
        }
        return lines;
    }

    public void calculateResults(Players players) {
        for (Line line : lines) {
            players.calculateResult(line);
        }
    }
}
