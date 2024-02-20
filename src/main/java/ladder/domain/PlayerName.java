package ladder.domain;

public class PlayerName {
    private final String name;

    public PlayerName(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateNotEmpty(name);
        validateMaxLength(name);
    }

    private void validateNotEmpty(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 한글자 이상이어야 합니다.");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5글자를 넘을 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
