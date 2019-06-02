package ladder;

import java.util.ArrayList;
import java.util.List;

public class LineGenerator {
    public static Line generate(int userSize) {
        List<Position> positions = new ArrayList<>();
        positions.add(Position.first(RandomGenerator.generateBoolean()));
        for (int i = 0; i < userSize - 2; i++) {
            positions.add(positions.get(i).next(i + 1, RandomGenerator.generateBoolean()));
        }
        positions.add((positions.get(userSize - 2).last(userSize - 1)));

        return new Line(positions);
    }
}
