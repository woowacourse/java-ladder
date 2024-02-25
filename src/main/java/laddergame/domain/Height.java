package laddergame.domain;

import java.util.regex.Pattern;

public class Height {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[\\d]*$");
    private static final String NATURAL_NUMBER_ERROR = "자연수를 입력해 주세요.";
    private static final int MAX_HEIGHT = 9;
    private final int height;

    public Height(String height) {
        validate(height);
        this.height = Integer.parseInt(height);
    }

    private void validate(final String height) {
        checkIsNotMinus(height);
        checkIsZero(height);
        checkHeightRange(height);
    }

    private void checkHeightRange(final String height) {
        if (Integer.parseInt(height) > MAX_HEIGHT) {
            throw new IllegalArgumentException();
        }
    }

    private void checkIsNotMinus(final String height) {
        if (!NUMBER_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException(NATURAL_NUMBER_ERROR);
        }
    }

    private void checkIsZero(final String height) {
        if (Integer.parseInt(height) == 0) {
            throw new IllegalArgumentException(NATURAL_NUMBER_ERROR);
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
