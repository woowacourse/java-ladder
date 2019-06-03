package ladder.model.generator;

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

        return Row.of(DirectionsGenerator.makeDirections(linkedData));
    }

    private static boolean generateBooleanValue() {
        return RANDOM.nextBoolean();
    }
}
