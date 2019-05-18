package ladder.domain;

public class RewardName {
    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_NAME_LENGTH = 1;

    private final String name;

    public RewardName(String name) {
        validateNotNull(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("보상은 " + MIN_NAME_LENGTH + "자 이상 " + MAX_NAME_LENGTH + "자 이하이어야 합니다.");
        }
    }

    private void validateNotNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("보상은 null일 수 없습니다.");
        }
    }
}
