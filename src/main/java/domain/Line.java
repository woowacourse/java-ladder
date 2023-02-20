package domain;

import exception.InvalidLineWeightException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Line {

    private static final int MIN_LINE_WEIGHT = 1;
    private static final int MAX_LINE_WEIGHT = 9;
    private static final int LINE_FIRST_INDEX = 9;

    private final List<Boolean> status = new ArrayList<>();

    public Line(int weight, BooleanGenerator booleanGenerator) {
        validate(weight);
        generate(weight, booleanGenerator);
    }

    private void validate(int weight) {
        if (!isValidWeight(weight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isValidWeight(int weight) {
        final int minHeight = 1;
        final int maxHeight = 9;
        return minHeight <= weight && weight <= maxHeight;
    }

    public void generate(int weight, BooleanGenerator booleanGenerator) {
        IntStream.range(0, weight)
                 .forEach((index) -> status.add(generateStatus(index, booleanGenerator)));
    }

    private boolean generateStatus(int index, BooleanGenerator booleanGenerator) {
        final int firstIndex = 0;
        final int prev = index - 1;
        final boolean connected = true;
        if (index != firstIndex && status.get(prev) == connected) {
            return false;
        }
        return booleanGenerator.generate();
    }

    public List<Boolean> getStatus() {
        return List.copyOf(status);
    }
}
