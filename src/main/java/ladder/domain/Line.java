package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import java.util.ArrayList;
import java.util.List;

public class Line {
    List<Direction> line;

    public Line(int size, LineGenerator lineGenerator) {
        initialize(size);
        for (int index = 0; index < size - 1; index++) {
            setDirections(lineGenerator, index);
        }
    }

    private void initialize(int size) {
        line = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            line.add(NONE);
        }
    }

    private void setDirections(LineGenerator lineGenerator, int index) {
        if (line.get(index) == NONE) {
            Direction direction = lineGenerator.generate();
            setDirectionAt(index, direction);
        }
    }

    private void setDirectionAt(int index, Direction direction) {
        if (direction == RIGHT) {
            line.set(index, RIGHT);
            line.set(index + 1, LEFT);
        }
    }


}
