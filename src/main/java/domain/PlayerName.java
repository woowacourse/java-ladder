package domain;

public class PlayerName {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
    }

    private void validateNotBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 5글자까지 가능합니다.");
        }
    }

    public String getName() {
        return name;
    }

}
