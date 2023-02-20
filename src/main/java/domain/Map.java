package domain;

import exception.InvalidLadderHeightException;
import exception.InvalidLineWeightException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import util.BooleanGenerator;
import util.StringUtil;

public class Map {

    private static final int MIN_LADDER_HEIGHT = 1;
    private static final int MAX_LADDER_HEIGHT = 10;
    private static final int MIN_LINE_WEIGHT = 1;
    private static final int MAX_LINE_WEIGHT = 9;

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
        if (invalidNumber(height) || invalidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
        if (invalidWeight(lineWeight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean invalidNumber(String height) {
        return StringUtil.isNullOrBlank(height) || !height.matches("^[1-9]*$");
    }

    private boolean invalidHeight(String heightInput) {
        final int height = Integer.parseInt(heightInput);
        return MIN_LADDER_HEIGHT > height || height > MAX_LADDER_HEIGHT;
    }

    private boolean invalidWeight(int lineWeight) {
        return MIN_LINE_WEIGHT > lineWeight || lineWeight > MAX_LINE_WEIGHT;
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
