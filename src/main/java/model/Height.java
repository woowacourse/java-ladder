package model;

public class Height {
    private static final int MINIMUM_HEIGHT_LIMIT = 1;

    private final int height;

    public Height(final String heightText) {
        int parsedHeight = parseIntWithCustomException(heightText);
        validateMinimumLimit(parsedHeight);
        this.height = parsedHeight;
    }

    public int getHeight() {
        return height;
    }

    private int parseIntWithCustomException(String heightText){
        try{
            return Integer.parseInt(heightText);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("사다리의 높이는 숫자만 입력해주세요.");
        }
    }

    private void validateMinimumLimit(int parsedHeight) {
        if (parsedHeight < MINIMUM_HEIGHT_LIMIT) {
            throw new IllegalArgumentException(String
                    .format("사다리의 길이는 최소 %s 이상이어야합니다.",MINIMUM_HEIGHT_LIMIT));
        }
    }
}
