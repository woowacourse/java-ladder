package domain.ladder.attirbute;

public class Height {

    private final int height;

    public Height(String inputNumber) {
        this.height = validateAndParse(inputNumber);
    }

    private int validateAndParse(String inputNumber) {
        validateIsNumeric(inputNumber);
        int parsedHeight = Integer.parseInt(inputNumber);
        validateSize(parsedHeight);
        return parsedHeight;
    }

    private void validateIsNumeric(String inputNumber) {
        if (!inputNumber.matches("\\d+")) {
            throw new IllegalArgumentException("높이는 숫자만 입력 가능합니다.");
        }
    }

    private void validateSize(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이는 1 이상이여야 합니다.");
        }
    }

    public int toInt() {
        return height;
    }
}
