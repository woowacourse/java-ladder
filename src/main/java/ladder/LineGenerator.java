package ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;

public class LineGenerator {

    public Line generate(BooleanSupplier connectionAttemptSupplier, int size) {
        List<Direction> directions = new ArrayList<>();
        Direction direction = Direction.STRAIGHT;

        while (directions.size() < size - 1) {
            boolean isGoingToPlace = connectionAttemptSupplier.getAsBoolean();
            direction = direction.next(isGoingToPlace);
            directions.add(direction);
        }
        directions.add(direction.nextAsLast());

        return new Line(directions);
    }
}
