package domain;

import java.util.regex.Pattern;

public class Height {

    private static final Pattern HEIGHT_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");

    private final int height;

    public Height(String height) {
        validateHeight(height);
        this.height = Integer.parseInt(height);
    }

    private static void validateHeight(String height) {
        if (height == null || !HEIGHT_FORMAT_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException("사다리의 최대 높이는 자연수여야 합니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
