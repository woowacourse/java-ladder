package domain.ladder;

import domain.booleangenerator.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "사다리의 높이는 자연수이어야 합니다.";
    private static final String HEIGHT_IS_LOWER_THAN_WIDTH_ERROR_MESSAGE = "사다리의 높이는 열의 개수 이상이어야 합니다.";

    private final List<Line> ladder;

    public Ladder(int height, int width, BooleanGenerator booleanGenerator) {
        ladder = new ArrayList<>();
        validate(height, width);
        generateLadder(height, width, booleanGenerator);
    }

    private static void validate(int height, int width) {
        validateHeightGreaterThanLowerBound(height);
        validateWidthLessThanHeight(height, width);
    }

    private static void validateWidthLessThanHeight(int height, int width) {
        if (height < width) {
            throw new IllegalArgumentException(HEIGHT_IS_LOWER_THAN_WIDTH_ERROR_MESSAGE);
        }
    }

    private static void validateHeightGreaterThanLowerBound(int height) {
        if (height < HEIGHT_LOWER_BOUND) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private void generateLadder(int height, int personCount, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(personCount, booleanGenerator));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
