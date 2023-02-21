package ladder.domain;

public class Player {
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNull(name);
        validateBlank(name);
        validateLength(name);
    }

    private void validateNull(String name) {
        if (name == null) {
            throw new IllegalArgumentException("[ERROR] 이름에 null 값이 들어갈 수 없습니다.");
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 이름은 공백이 될 수 없습니다.");
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 이름이 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
