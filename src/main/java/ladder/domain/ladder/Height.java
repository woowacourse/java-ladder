package ladder.domain.ladder;

public class Height {

    private static final int MIN_HEIGHT_RANGE = 1;
    private static final int MAX_HEIGHT_RANGE = 100;

    private final int height;

    public Height(String input) {
        int heightValue = changeInputToInteger(input);
        validateNumberIsIntRange(heightValue);
        this.height = heightValue;
    }

    private void validateNumberIsIntRange(int heightValue) {
        if (heightValue < MIN_HEIGHT_RANGE || MAX_HEIGHT_RANGE < heightValue) {
            throw new IllegalArgumentException("입력된 높이가 정해진 규칙에 맞지 않습니다.");
        }
    }

    private int changeInputToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자로 입력을 변환할 수 없습니다.");
        }
    }

    public int getValue() {
        return height;
    }
}
