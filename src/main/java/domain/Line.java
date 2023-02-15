package domain;

import exception.InvalidLineWeightException;
import util.BooleanGenerator;

public class Line {

    private final boolean[] status;

    public Line(int weight) {
        validate(weight);
        status = new boolean[weight];
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

    public void generate(BooleanGenerator booleanGenerator) {
        for (int index = 0; index < status.length; index++) {
            status[index] = generateStatus(index, booleanGenerator);
        }
    }

    private boolean generateStatus(int index, BooleanGenerator booleanGenerator) {
        final int firstIndex = 0;
        final boolean connected = true;
        final int prev = index - 1;
        if (index != firstIndex && status[prev] == connected) {
            return false;
        }
        return booleanGenerator.generate();
    }

    public boolean[] getStatus() {
        return status;
    }
}
