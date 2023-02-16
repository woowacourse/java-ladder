package domain;

public class Height {
    public static final String HEIGHT_FORMAT_ERROR_MESSAGE = "[ERROR] 사다리 높이는 숫자만 가능합니다.";
    public static final String INPUT_NOTHING_ERROR_MESSAGE = "[ERROR] 값을 입력하지 않았습니다.";

    private final int height;

    public Height(String heightInput) {
        validateHeightFormat(heightInput);
        this.height = convertHeightInput(heightInput);
    }

    private void validateHeightFormat(String heightInput) {
        if (!heightInput.matches("^[0-9]*$")) {
            throw new IllegalArgumentException(HEIGHT_FORMAT_ERROR_MESSAGE);
        }
    }

    private int convertHeightInput(String heightInput) {
        try {
            return Integer.parseInt(heightInput);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(INPUT_NOTHING_ERROR_MESSAGE);
        }
    }
}
