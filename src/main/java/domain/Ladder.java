package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final String NOT_NATURAL_NUMBER_ERROR_MESSAGE = "사다리의 높이는 자연수이어야 합니다.";
    private static final String HEIGHT_IS_LOWER_THAN_PERSON_COUNT_ERROR_MESSAGE = "사다리의 높이는 참가자 수 이상이어야 합니다.";

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int personCount) {
        validate(height, personCount);
        generateLadder(height, personCount);
    }

    private static void validate(int height, int personCount) {
        validateHeightGreaterThanLowerBound(height);
        validatePersonCountLessThanHeight(height, personCount);
    }

    private static void validatePersonCountLessThanHeight(int height, int personCount) {
        if (height < personCount) {
            throw new IllegalArgumentException(HEIGHT_IS_LOWER_THAN_PERSON_COUNT_ERROR_MESSAGE);
        }
    }

    private static void validateHeightGreaterThanLowerBound(int height) {
        if (height < HEIGHT_LOWER_BOUND) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_ERROR_MESSAGE);
        }
    }

    private void generateLadder(int height, int personCount) {
        BooleanGenerator booleanGenerator = new RandomBooleanGenerator();
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(booleanGenerator, personCount));
        }
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}
