package laddergame.domain;

import java.util.regex.Pattern;

public class Height {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[\\d]*$");
    private static final String HEIGHT_BLANK_ERROR = "사다리 높이는 빈 입력을 허용하지 않습니다. 자연수를 입력해주세요.";
    private static final String NATURAL_NUMBER_ERROR = "사다리 높이는 자연수만을 허용합니다. 입력된 사다리 높이는 %s 입니다.";
    private static final String INVALID_HEIGHT_RANGE = "사다리 높이는 반드시 1 이상, 9 이하로 이루어져야 합니다. 입력된 사다리 높이는 %s 입니다.";
    private static final int MAX_HEIGHT = 9;
    private final int height;

    public Height(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    private void validate(final String height) {
        checkIsBlank(height);
        checkIsNotMinus(height);
        checkIsZero(height);
        checkHeightRange(height);
    }

    private void checkIsBlank(final String height) {
        if (height.isBlank()) {
            throw new IllegalArgumentException(HEIGHT_BLANK_ERROR);
        }
    }

    private void checkHeightRange(final String height) {
        if (Integer.parseInt(height) > MAX_HEIGHT) {
            throw new IllegalArgumentException(String.format(INVALID_HEIGHT_RANGE, height));
        }
    }

    private void checkIsNotMinus(final String height) {
        if (!NUMBER_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException(String.format(NATURAL_NUMBER_ERROR, height));
        }
    }

    private void checkIsZero(final String height) {
        if (Integer.parseInt(height) == 0) {
            throw new IllegalArgumentException(String.format(NATURAL_NUMBER_ERROR, height));
        }
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        final Height height1 = (Height) o;

        return height == height1.height;
    }

    @Override
    public int hashCode() {
        return height;
    }
}
