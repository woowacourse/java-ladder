package domain;

import java.util.regex.Pattern;

public class Height {

    static final String ERROR_HEIGHT_IS_NOT_NATURAL_NUMBER = "사다리의 높이는 자연수여야 합니다.";
    private static final Pattern NATURAL_NUMBER_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");

    private final int height;

    public Height(String height) {
        validateHeight(height);
        this.height = Integer.parseInt(height);
    }

    private void validateHeight(String height) {
        if (height == null || !NATURAL_NUMBER_FORMAT_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException(ERROR_HEIGHT_IS_NOT_NATURAL_NUMBER);
        }
    }

    public int getHeight() {
        return height;
    }
}
