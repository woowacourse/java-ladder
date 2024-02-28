package ladder.domain.prize;

public class Prize {

    private static final int MAX_NAME_LENGTH = 5;
    private static final String BLANK = " ";

    private final String prizeName;

    public Prize(String prizeName) {
        validatePrizeName(prizeName);
        this.prizeName = prizeName;
    }

    private void validatePrizeName(String name) {
        validatePrizeNameLength(name);
        validateBlankInPrizeName(name);
    }

    private void validatePrizeNameLength(String name) {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateBlankInPrizeName(String name) {
        if (name.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 실행 결과의 이름 내에는 공백을 허용하지 않습니다.");
        }
    }
}
