package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;

public class Line {
    List<Direction> line;

    public Line(int size, LineGenerator lineGenerator) {
        line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(NONE);
        }
        for (int i = 0; i < size - 1; i++) {
            if (line.get(i) == NONE) {
                Direction direction = lineGenerator.getDirection();
                line.set(i, direction);
                if (direction == RIGHT) {
                    line.set(i + 1, LEFT);
                }
            }
        }
    }
}
