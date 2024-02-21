package domain;

public class Player {
    private final String name;

    public Player(final String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if ((name.isBlank() || name.length() > 5)) {
            throw new IllegalArgumentException("참가자 이름은 1~5자 이내로 입력해야합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
