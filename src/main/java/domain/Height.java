package domain;

import exception.ErrorCode;

public class Height {
    private static final int MIN_HEIGHT = 2;
    private static final int MAX_HEIGHT = 100;

    private final int height;

    private Height(int height) {
        this.height = height;
    }

    public static Height from(String height) {
        return new Height(validate(height));
    }

    private static int validate(String height) {
        int integerNumber = getIntegerNumber(height);
        validateNumberRange(integerNumber);
        return integerNumber;
    }

    private static int getIntegerNumber(String height) {
        try {
            return Integer.parseInt(height);
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_NOT_INTEGER.getMessage());
        }
    }

    private static void validateNumberRange(int integerNumber) {
        if (integerNumber < MIN_HEIGHT || MAX_HEIGHT < integerNumber) {
            throw new IllegalArgumentException(ErrorCode.NUMBER_NOT_RANGE.getMessage());
        }
    }

    public int getHeight() {
        return height;
    }
}
