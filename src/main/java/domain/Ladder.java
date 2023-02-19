package domain;

import exception.InvalidLadderHeightException;
import exception.InvalidLineWeightException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Ladder {

    private static final int MIN_LADDER_COUNT = 1;
    private static final int MAX_LADDER_COUNT = 10;
    private static final int MIN_LINE_WEIGHT = 1;
    private static final int MAX_LINE_WEIGHT = 9;
    private final int height;
    private final int lineWeight;
    private final List<Line> lines;

    public Ladder(String height, int lineWeight, BooleanGenerator booleanGenerator) {
        validate(height, lineWeight);
        this.height = Integer.parseInt(height);
        this.lineWeight = lineWeight;
        lines = generate(booleanGenerator);
    }

    private void validate(String height, int lineWeight) {
        if (isNotNum(height) || isInValidHeight(Integer.parseInt(height))) {
            throw new InvalidLadderHeightException();
        }
        if (isInvalidWeight(lineWeight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isNotNum(String height) {
        try {
            Integer.parseInt(height);
            return false;
        } catch (NumberFormatException exception) {
            return true;
        }
    }

    private boolean isInValidHeight(int heightInput) {
        return MIN_LADDER_COUNT > heightInput || heightInput > MAX_LADDER_COUNT;
    }

    private boolean isInvalidWeight(int lineWeight) {
        return MIN_LINE_WEIGHT > lineWeight || lineWeight > MAX_LINE_WEIGHT;
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }

    private List<Line> generate(BooleanGenerator booleanGenerator) {
        return IntStream.range(0, height)
            .mapToObj((count) -> new Line(lineWeight, booleanGenerator))
            .collect(Collectors.toList());
    }
}
