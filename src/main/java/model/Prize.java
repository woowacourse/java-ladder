package model;

public class Prize {
    private static final int MAX_PRIZE_LENGTH = 5;

    private final String prizeName;

    public Prize(String prizeName) {
        validator(prizeName);
        this.prizeName = prizeName;
    }

    private void validator(String prizeName) {
        if (prizeName == null) {
            throw new IllegalArgumentException("결과 이름은 null일 수 없다.");
        }
        if (prizeName.isEmpty() || prizeName.isBlank() || prizeName.length() > MAX_PRIZE_LENGTH) {
            throw new IllegalArgumentException("결과 이름은 한글자 이상 다섯글자 이하로 입력해야합니다.");
        }
    }
}
