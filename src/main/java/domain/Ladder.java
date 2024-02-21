package domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private int height;
    private List<Line> lines;

    public Ladder(int height) {
        validate(height);
        this.height = height;
        this.lines = new ArrayList<>();
    }

    public void makeLines(int playerCount) {
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.makeLeg(playerCount-1);
            lines.add(line);
        }
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("[Error] 사다리 높이는 1이상 이어야 합니다.");
        }
    }
    public List<Line> getLines() {
        return lines;
    }
}
