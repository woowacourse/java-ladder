package laddergame;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    public Ladder(final int height, final int personSize, final BooleanGenerator booleanGenerator) {
        List<Line> lines = new ArrayList<>();
        for(int i=0; i<height; i++) {
            lines.add(new Line(personSize, booleanGenerator));
        }

        this.lines = lines;
    }

    public int getHeight() {
        return lines.size();
    }
}
