package domain.player;

public record PlayerName(String value) {

    private static final int MAX_NAME_LENGTH = 5;

    public PlayerName {
        validateLength(value);
    }

    private void validateLength(final String value) {
        if (value.isEmpty() || value.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1자 이상 %d자 이하 이어야 합니다.", MAX_NAME_LENGTH));
        }
    }
}
