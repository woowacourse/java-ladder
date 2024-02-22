package domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if ((name.isBlank() || name.length() > MAX_NAME_LENGTH)) {
            throw new IllegalArgumentException("참가자 이름은 1~%d자 이내로 입력해야합니다.".formatted(MAX_NAME_LENGTH));
        }
    }

    public String getName() {
        return name;
    }
}
