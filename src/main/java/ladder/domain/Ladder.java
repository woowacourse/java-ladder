package ladder.domain;

import java.util.ArrayList;
 import java.util.Collections;
import java.util.List;

public class Ladder {
    private List<Line> lines;

    public Ladder(int numberOfPlayers, int height) {
        lines = new ArrayList<>();
        addLines(numberOfPlayers, height);
    }

    private void addLines(int numberOfPlayers, int height) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(numberOfPlayers));
        }
    }

    public int getHeight(){
        return lines.size();
    }

    public Line get(int index) {
        return lines.get(index);
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}
