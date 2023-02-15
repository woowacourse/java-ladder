package domain;

import exception.InvalidLadderHeightException;
import exception.InvalidLineWeightException;
import java.util.ArrayList;
import java.util.List;
import util.BooleanGenerator;

public class Ladder {

    private final int height;
    private final int lineWeight;
    private final List<Line> lines = new ArrayList<>();

    public Ladder(String height, int participantCount) {
        final int lineWeight = participantCount - 1;
        validate(height, lineWeight);
        this.height = Integer.parseInt(height);
        this.lineWeight = lineWeight;
    }

    private void validate(String height, int lineWeight) {
        if (!isNum(height) || !isValidHeight(height)) {
            throw new InvalidLadderHeightException();
        }
        if (!isValidLineWeight(lineWeight)) {
            throw new InvalidLineWeightException();
        }
    }

    private boolean isNum(String height) {
        return !(height == null || height.isBlank() || !height.matches("^[1-9]*$"));
    }

    private boolean isValidHeight(String heightInput) {
        final int minLadderCount = 1;
        final int maxLadderCount = 10;
        final int height = Integer.parseInt(heightInput);
        return !(height < minLadderCount || height > maxLadderCount);
    }

    private boolean isValidLineWeight(int lineWeight) {
        final int minLineWeight = 1;
        final int maxLineWeight = 9;
        return !(lineWeight < minLineWeight || lineWeight > maxLineWeight);
    }

    public void generate(BooleanGenerator booleanGenerator) {
        for (int count = 0; count < height; count++) {
            Line line = new Line(lineWeight);
            line.generate(booleanGenerator);
            lines.add(line);
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}
