package domain.players;

public class PlayerName {

    private static final int PLAYER_NAME_MAX_LENGTH = 5;
    private static final String FORBIDDEN_NAME = "all";

    private final String name;

    public PlayerName(final String name) {
        validate(name);
        this.name = name;
    }

    private void validate(final String name) {
        validateNotBlank(name);
        validateNameLength(name);
        validateNotForbiddenName(name);
    }

    private void validateNotBlank(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("참여자 이름은 공백일 수 없습니다.");
        }
    }

    private void validateNameLength(final String name) {
        if (name.length() > PLAYER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("참여자 이름은 최대 5글자까지 가능합니다.");
        }
    }

    private void validateNotForbiddenName(final String name) {
        if (name.equals(FORBIDDEN_NAME)) {
            throw new IllegalArgumentException("참여자 이름은 \"all\"일 수 없습니다.");
        }
    }

    public boolean isMyName(String playerName) {
        return playerName.equals(name);
    }

    public String getName() {
        return name;
    }

}
