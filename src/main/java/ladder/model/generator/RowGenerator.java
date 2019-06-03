package ladder.model.generator;

import ladder.model.Direction;
import ladder.model.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RowGenerator {
    private static final Random RANDOM = new Random();

    public static Row generateRow(final int numberOfMember) {
        List<Boolean> linkedData = new ArrayList<>();

        for (int i = 0; i < numberOfMember - 1; i++) {
            linkedData.add(generateBooleanValue());
        }

        return Row.of(makeDirections(linkedData));
    }

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

    private static boolean generateBooleanValue() {
        return RANDOM.nextBoolean();
    }
}
