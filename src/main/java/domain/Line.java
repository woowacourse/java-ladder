package domain;

import exception.InvalidLineWeightException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Line {

    private static final int MIN_HEIGHT = 1;
    private static final int MAX_HEIGHT = 9;
    private static final int FIRST_INDEX = 0;
    private static final boolean CONNECTED = true;
    private final List<Boolean> blocks = new ArrayList<>();

    public Line(int weight, BooleanGenerator booleanGenerator) {
        validate(weight);
        generate(weight, booleanGenerator);
    }

    private void validate(int weight) {
        if (isInvalidWeight(weight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isInvalidWeight(int weight) {
        return MIN_HEIGHT > weight || weight > MAX_HEIGHT;
    }

    public void generate(int weight, BooleanGenerator booleanGenerator) {
        IntStream.range(0, weight)
            .forEach((index) -> blocks.add(generateStatus(index, booleanGenerator)));
    }

    private boolean generateStatus(int index, BooleanGenerator booleanGenerator) {
        final int prev = index - 1;
        if (index != FIRST_INDEX && blocks.get(prev) == CONNECTED) {
            return false;
        }
        return booleanGenerator.generate();
    }

    public List<Boolean> getBlocks() {
        return List.copyOf(blocks);
    }
}
