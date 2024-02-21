package domain;

import static message.ErrorMessage.*;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final int height;
    private final List<Line> lines;

    public Ladder(int height) {
        validate(height);
        this.height = height;
        this.lines = new ArrayList<>();
    }

    public void makeLines(int width) {
        for (int i = 0; i < height; i++) {
            Line line = new Line();
            line.makeLeg(width);
            lines.add(line);
        }
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException(INVALID_LADDER_HEIGHT_EXCEPTION.getMessage());
        }
    }
    public List<Line> getLines() {
        return lines;
    }
}
