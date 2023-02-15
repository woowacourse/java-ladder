package domain;

import java.util.ArrayList;
import java.util.List;

import domain.numbergenerator.NumberGenerator;

public class Ladder {

    private static final int HEIGHT_LOWER_BOUND = 1;
    private static final String NOT_NATURAL_NUMBER_MESSAGE = "사다리의 높이는 자연수이어야 합니다.";
    private static final String HEIGHT_IS_LOWER_THAN_PERSON_COUNT_MESSAGE = "사다리의 높이는 참가자 수 이상이어야 합니다.";

    private final List<Line> ladder = new ArrayList<>();

    public Ladder(int height, int personCount, NumberGenerator numberGenerator) {
        validate(height, personCount);
        generateLadder(height, personCount, numberGenerator);
    }

    private static void validate(int height, int personCount) {
        validateHeight(height);
        validateHeightCompareWithPersonCount(height, personCount);
    }

    private static void validateHeightCompareWithPersonCount(int height, int personCount) {
        if (height < personCount) {
            throw new IllegalArgumentException(HEIGHT_IS_LOWER_THAN_PERSON_COUNT_MESSAGE);
        }
    }

    private static void validateHeight(int height) {
        if (height < HEIGHT_LOWER_BOUND) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER_MESSAGE);
        }
    }

    private void generateLadder(int height, int personCount, NumberGenerator numberGenerator) {
        for (int i = 0; i < height; i++) {
            ladder.add(new Line(personCount, numberGenerator));
        }
    }

    public List<Line> getLadder() {
        return ladder;
    }
}
