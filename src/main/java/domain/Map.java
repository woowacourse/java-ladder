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
        this.ladder = generate(booleanGenerator);
    }

    private void validate(String height, int lineWeight) {
        if (!isNumber(height) || !isValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
        if (!isValidLineWeight(lineWeight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isNumber(String height) {
        return !(height == null || height.isBlank() || !height.matches("^[1-9]*$"));
    }

    private boolean isValidHeight(String heightInput) {
        final int minLadderHeight = 1;
        final int maxLadderHeight = 10;
        final int height = Integer.parseInt(heightInput);
        return minLadderHeight <= height && height <= maxLadderHeight;
    }

    private boolean isValidLineWeight(int lineWeight) {
        final int minLineWeight = 1;
        final int maxLineWeight = 9;
        return minLineWeight <= lineWeight && lineWeight <= maxLineWeight;
    }

    private Ladder generate(BooleanGenerator booleanGenerator) {
        List<Line> lines = IntStream.range(0, height).mapToObj((count) -> new Line(lineWeight, booleanGenerator))
            .collect(Collectors.toList());
        return new Ladder(lines);
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }
}
