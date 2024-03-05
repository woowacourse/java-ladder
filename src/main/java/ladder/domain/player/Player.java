package ladder.domain.player;

public record Player(String name) {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;

    public Player {
        if (name.isEmpty() || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 %d~%d글자로 입력해주세요: %s".formatted(MIN_LENGTH, MAX_LENGTH, name));
        }
    }
}
