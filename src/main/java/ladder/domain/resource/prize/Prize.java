package ladder.domain.resource.prize;

public class Prize {

    private static final String BLANK = " ";
    private static final int MAX_NAME_LENGTH = 5;

    private final String prizeName;

    public Prize(String prizeName) {
        validateNameLength(prizeName);
        validateContainedBlank(prizeName);
        this.prizeName = prizeName;
    }

    private void validateNameLength(String prizeNameToAdd) {
        if (prizeNameToAdd.isEmpty() || prizeNameToAdd.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 상품 이름의 길이는 1~5글자여야 합니다.");
        }
    }

    private void validateContainedBlank(String prizeNameToAdd) {
        if (prizeNameToAdd.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 상품 이름 내에는 공백을 허용하지 않습니다.");
        }
    }

    public String getPrizeName() {
        return prizeName;
    }
}
