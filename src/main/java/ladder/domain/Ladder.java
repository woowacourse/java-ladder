package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<HorizontalLine> lines; // top to bottom

    public Ladder(List<HorizontalLine> lines) {
        this.lines = lines;
    }

    public static Ladder create(int height, int numPosition) {
        List<HorizontalLine> generatedLines = new ArrayList<>();
        for (int h = 0; h < height; h++) {
            generatedLines.add(HorizontalLine.create(numPosition));
        }
        return new Ladder(generatedLines);
    }

    public static Ladder create(List<HorizontalLine> lines) {
        return new Ladder(lines);
    }

    public Position nextPosition(Position from) {
        Position p = from;
        for (HorizontalLine line : lines) {
            p = line.nextPosition(p);
        }
        return p;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (HorizontalLine line : lines) {
            sb.append(line.toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
