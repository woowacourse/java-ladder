package ladder.domain;

public class LadderHeight {
    private static final int MIN_HEIGHT = 1;
    private static final String NUMERIC_REGEX = "-?\\d+(\\.\\d+)?";
    private static final String NUMERIC_LADDER_HEIGHT = "사다리의 높이는 숫자이어야 합니다.";
    private static final String MIN_LADDER_HEIGHT = "사다리의 높이는 1 이상의 정수이어야 합니다.";

    private final int value;

    private LadderHeight(int value) {
        validateMin(value);
        this.value = value;
    }

    public static LadderHeight from(String height) {
        String strippedHeight = height.strip();
        validateNumeric(strippedHeight);
        return new LadderHeight(Integer.parseInt(strippedHeight));
    }

    private static void validateNumeric(String height) {
        if (!height.matches(NUMERIC_REGEX)) {
            throw new IllegalArgumentException(NUMERIC_LADDER_HEIGHT);
        }
    }

    private static void validateMin(int value) {
        if (value < MIN_HEIGHT) {
            throw new IllegalArgumentException(MIN_LADDER_HEIGHT);
        }
    }

    public int getValue() {
        return value;
    }
}
