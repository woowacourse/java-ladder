package ladder.domain.resource.prize;

public class Prize {

    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String prizeName;

    public Prize(String prizeName) {
        validatePrizeName(prizeName);
        this.prizeName = prizeName;
    }

    private void validatePrizeName(String prizeName) {
        validateNameLength(prizeName);
        validateContainedBlank(prizeName);
    }

    private void validateNameLength(String prizeName) {
        if (prizeName.isEmpty() || prizeName.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 상품 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateContainedBlank(String prizeName) {
        if (prizeName.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 상품 이름 내에는 공백을 허용하지 않습니다.");
        }
    }
}
