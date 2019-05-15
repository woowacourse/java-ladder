package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final String[] names;
    private final List<Line> lines;

    public Ladder(String[] names, int height) {
        this.names = names;
        lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(names.length));
        }
    }

    public int getHeight(){
        return lines.size();
    }
}
