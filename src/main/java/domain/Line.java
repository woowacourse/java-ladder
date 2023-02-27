package domain;

import exception.InvalidLineWeightException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import util.BooleanGenerator;

public class Line {

    private static final int MIN_LINE_WEIGHT = 1;
    private static final int MAX_LINE_WEIGHT = 9;
    private static final int LINE_FIRST_INDEX = 0;

    private final List<LineStatus> status = new ArrayList<>();

    public Line(int weight, BooleanGenerator booleanGenerator) {
        validate(weight);
        generate(weight, booleanGenerator);
    }

    private void validate(int weight) {
        if (invalidWeight(weight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean invalidWeight(int weight) {
        return MIN_LINE_WEIGHT > weight || weight > MAX_LINE_WEIGHT;
    }

    public void generate(int weight, BooleanGenerator booleanGenerator) {
        IntStream.range(0, weight)
                 .forEach((index) -> status.add(generateStatus(index, booleanGenerator)));
    }

    private LineStatus generateStatus(int index, BooleanGenerator booleanGenerator) {
        final int prev = index - 1;
        if (index != LINE_FIRST_INDEX && status.get(prev) == LineStatus.CONNECTED) {
            return LineStatus.DISCONNECTED;
        }
        return LineStatus.getStatus(booleanGenerator.generate());
    }

    public List<LineStatus> getStatus() {
        return List.copyOf(status);
    }

    public boolean canMoveLeft(int index) {
        return index > 0 && status.get(index - 1) == LineStatus.CONNECTED;
    }

    public boolean canMoveRight(int index) {
        return index < status.size() && status.get(index) == LineStatus.CONNECTED;
    }
}
