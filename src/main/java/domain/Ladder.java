package domain;

import static message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final Height height;
    private final List<Line> lines;

    public Ladder(int height) {
        this.height = new Height(height);
        this.lines = new ArrayList<>();
    }

    public void makeLines(int width) {
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = new Line();
            line.makeLeg(width);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
