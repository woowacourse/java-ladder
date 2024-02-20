package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(int width) {
        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            directions.add(Direction.N);
        }
        return new Line(directions);
    }
}
