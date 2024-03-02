package domain.player;

public class PlayerName {
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;
    public static final String PLAYER_NAME_BLANK = "참가자 이름으로 공백을 사용할 수 없습니다";
    public static final String PLAYER_NAME_LENGTH = String.format("참가자 이름은 1글자 이상 5글자 이하여야 합니다.");

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateIsBlank(name);
        validateNameLength(name);
    }

    private void validateIsBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(PLAYER_NAME_BLANK);
        }
    }

    private void validateNameLength(final String name) {
        int nameLength = name.length();
        if (nameLength > MAX_NAME_LENGTH || nameLength < MIN_NAME_LENGTH) {
            throw new IllegalArgumentException(PLAYER_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
