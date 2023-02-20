package domain;

import exception.InvalidLineWeightException;

public class Weight {

    private static final int MIN_WEIGHT = 1;
    private static final int MAX_WEIGHT = 9;

    private final int weight;

    public Weight(int participantCount) {
        int weight = participantCount - 1;
        validate(weight);
        this.weight = weight;
    }

    private void validate(int weight) {
        if (invalidWeight(weight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean invalidWeight(int weight) {
        return MIN_WEIGHT > weight || weight > MAX_WEIGHT;
    }

    public int getWeight() {
        return weight;
    }
}
