package domain.ladder;

import exception.ladder.InvalidLineWeightException;

public class LineWeight {

    private static final int MIN_LINE_WEIGHT = 1;
    private static final int MAX_LINE_WEIGHT = 9;
    private final int weight;

    public LineWeight(int weight) {
        validate(weight);
        this.weight = weight;
    }

    private void validate(int weight) {
        if (isInvalidWeight(weight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isInvalidWeight(int heightInput) {
        return heightInput < MIN_LINE_WEIGHT || heightInput > MAX_LINE_WEIGHT;
    }

    public int getWeight() {
        return weight;
    }
}
