package model;

public class Height {
    private static final int MINIMUM_HEIGHT_LIMIT = 1;

    private final int height;

    public Height(final String heightText) {
        validateNaturalNumber(heightText);
        this.height = Integer.parseInt(heightText);
    }

    public int getHeight() {
        return height;
    }

    private void validateNaturalNumber(String inputData) {
        if (Integer.parseInt(inputData) <= MINIMUM_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(String
                    .format("사다리의 길이는 최소 %s 이상이어야합니다.",MINIMUM_HEIGHT_LIMIT));
        }
    }
}
