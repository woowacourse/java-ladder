package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    List<Integer> line;

    public Line(int size) {
        line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(0);
        }
        for (int i = 0; i < size - 1; i++) {
            if (line.get(i) == 0) {
                line.set(i, 1);
                line.set(i+1, -1);
            }
        }
    }
}
