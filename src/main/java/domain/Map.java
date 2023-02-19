package domain;

import exception.InvalidLadderHeightException;
import exception.InvalidLineWeightException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import util.BooleanGenerator;

public class Map {

    private final int height;
    private final int lineWeight;
    private final Ladder ladder;

    public Map(String height, int participantCount, BooleanGenerator booleanGenerator) {
        final int lineWeight = participantCount - 1;
        validate(height, lineWeight);
        this.height = Integer.parseInt(height);
        this.lineWeight = lineWeight;
        ladder = generate(booleanGenerator);
    }

    private void validate(String height, int lineWeight) {
        if (isNotNum(height) || isInValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
        if (isInvalidWeight(lineWeight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isNotNum(String height) {
        return height == null || height.isBlank() || !height.matches("^[1-9]*$");
    }

    private boolean isInValidHeight(String heightInput) {
        final int minLadderCount = 1;
        final int maxLadderCount = 10;
        final int height = Integer.parseInt(heightInput);
        return minLadderCount > height || height > maxLadderCount;
    }

    private boolean isInvalidWeight(int lineWeight) {
        final int minLineWeight = 1;
        final int maxLineWeight = 9;
        return minLineWeight > lineWeight || lineWeight > maxLineWeight;
    }

    private Ladder generate(BooleanGenerator booleanGenerator) {
        List<Line> lines = IntStream.range(0, height)
            .mapToObj((count) -> new Line(lineWeight, booleanGenerator))
            .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
