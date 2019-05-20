package ladder.model;

import ladder.constant.MessageConstant;

import java.util.Objects;
import java.util.regex.Pattern;

public class LadderHeight {
    public static final int MIN_HEIGHT = 1;
    private int height;

    public LadderHeight(String height) {
        this.height = getAccuracyOf(height);
    }

    public LadderHeight(int height) {
        this.height = checkMinValueOf(height);
    }

    private int getAccuracyOf(String height) {
        if (isHeightEmpty(height)) {
            throw new IllegalArgumentException(MessageConstant.ERROR_EMPTY_VALUE);
        }
        height = height.trim();
        if (!isIntegerNumber(height)) {
            throw new NumberFormatException(MessageConstant.ERROR_NOT_INTEGER);
        }
        return checkMinValueOf(Integer.parseInt(height));
    }

    private int checkMinValueOf(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(MessageConstant.ERROR_BELOW_HEIGHT);
        }
        return height;
    }

    private boolean isHeightEmpty(String input) {
        return input == null || input.trim().isEmpty();
    }

    private boolean isIntegerNumber(String input) {
        return Pattern.matches("-?[1-9]\\d*|0", input);
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LadderHeight that = (LadderHeight) o;
        return height == that.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(height);
    }
}
