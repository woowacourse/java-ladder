package model;

public class Prize {
    private static final int MAX_LIMIT = 5;

    private final String prizeName;

    public Prize(String prizeName) {
        validatePrizeNameSize(prizeName);
        this.prizeName = prizeName;
    }

    private void validatePrizeNameSize(String prizeName) {
        if (prizeName == null || prizeName.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 실행 결과 이름은 null이거나 공백일 수 없다.");
        }

        if (prizeName.length() > MAX_LIMIT) {
            throw new IllegalArgumentException("[ERROR] 실행 결과 이름의 길이는 " + MAX_LIMIT + "자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return prizeName;
    }
}
