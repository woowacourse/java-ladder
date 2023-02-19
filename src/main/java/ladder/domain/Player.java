package ladder.domain;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        validateNullName(name);
        validateBlankName(name);
        validateNameLength(name);
    }

    private void validateNullName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("[ERROR] 이름에 null 값이 들어갈 수 없습니다.");
        }
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백이 될 수 없습니다.");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
