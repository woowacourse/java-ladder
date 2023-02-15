package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Floor {

    private final List<Line> lines = new ArrayList<>();


    public Floor(int lineSize) {
        for (int i = 0; i < lineSize; i++) {
            lines.add(new Line());
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public void b(List<Integer> lineValues) {
        for (int i = 0; i < lines.size(); i++) {
            lines.get(i).make(lineValues.get(i));
        }
    }
}
