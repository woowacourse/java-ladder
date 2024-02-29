package ladder.domain;

public record Player(String name) {

    private static final int MAX_NAME_LENGTH = 5;
    public static Player ALL = new Player("all");

    public Player {
        if (name.isEmpty() || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 %d글자 이하로 입력해주세요.".formatted(MAX_NAME_LENGTH));
        }
    }
}
