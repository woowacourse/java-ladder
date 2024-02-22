package ladder.domain;

public class Height {

    private static final int MIN_HEIGHT_RANGE = 1;
    private static final int MAX_HEIGHT_RANGE = 100;

    private final int height;

    public Height(String input) {
        int number = changeInputToInteger(input);
        validateNumberIsIntRange(number);
        this.height = number;
    }

    private int changeInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("숫자로 입력을 변환할 수 없습니다.");
        }
    }

    private void validateNumberIsIntRange(int number) {
        if (number < MIN_HEIGHT_RANGE || number > MAX_HEIGHT_RANGE) {
            throw new IllegalArgumentException("입력된 높이가 정해진 규칙에 맞지 않습니다.");
        }
    }

    public int getHeight() {
        return height;
    }
}
