package ladder.model.generator;

import ladder.model.Direction;

import java.util.ArrayList;
import java.util.List;

public class DirectionsGenerator {
    public static List<Direction> makeDirections(final List<Boolean> linkedData) {
        List<Direction> row = new ArrayList<>();
        Direction direction = Direction.first(linkedData.get(0));

        row.add(direction);
        for (int i = 1; i < linkedData.size(); i++) {
            direction = direction.next(linkedData.get(i));
            row.add(direction);
        }
        row.add(direction.last());

        return row;
    }
}
