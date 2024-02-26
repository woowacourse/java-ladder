package model;

public record Height(int value) {

    private static final String NOT_POSITIVE_HEIGHT = "최대 사다리의 높이는 양수가 되어야 합니다.";

    public Height {
        if (value <= 0) {
            throw new IllegalArgumentException(NOT_POSITIVE_HEIGHT);
        }
    }
}
