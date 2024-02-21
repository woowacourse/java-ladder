package domain;

import java.util.ArrayList;
import java.util.List;

class Ladder {

    private List<Line> lines = new ArrayList<>();

    public Ladder(int height, int playerSize) {
        if (height < 1) {
            throw new IllegalArgumentException("사다리의 높이는 최소 1 이어야 합니다.");
        }
        for (int i = 0; i < height; i++) {
            lines.add(new Line(new RandomStickGenerator(), playerSize));
        }
    }

    public List<Line> getLines() {
        return this.lines;
    }
}
