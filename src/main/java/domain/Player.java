package domain;

public class Player {

    static final String ERROR_PLAYER_NAME_IS_NULL_OR_BLANK = "참여자 이름을 입력해 주세요.";
    static final String ERROR_MAX_NAME_LENGTH = "이름은 공백 포함 5글자를 초과할 수 없습니다.";
    private static final Integer MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateNameIsNullOrBlank(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameIsNullOrBlank(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(ERROR_PLAYER_NAME_IS_NULL_OR_BLANK);
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_MAX_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
