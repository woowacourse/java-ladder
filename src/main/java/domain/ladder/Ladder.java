package domain.ladder;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(Height height, int playerSize, StickGenerator stickGenerator) {
        this.height = height;

        for (int i = 0; i < height.getHeight(); i++) {
            addLine(stickGenerator, playerSize);
        }
    }

    private void addLine(StickGenerator stickGenerator, int playerSize) {
        this.lines.add(new Line(stickGenerator, playerSize));
    }

    public List<Line> getLines() {
        return this.lines;
    }

    public int getHeight() {
        return this.height.getHeight();
    }
}
