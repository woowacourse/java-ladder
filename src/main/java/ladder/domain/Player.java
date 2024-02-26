package ladder.domain;

public record Player(String name, int location) {

    private static final int MAX_NAME_LENGTH = 5;

    public Player {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    "이름은 1~%d글자 사이로 입력해주세요: %s".formatted(MAX_NAME_LENGTH, name)
            );
        }
    }

    public boolean hasSameLocation(int location) {
        return this.location == location;
    }
}
