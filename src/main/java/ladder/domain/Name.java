package ladder.domain;

public class Name {
    private static final int MAX_SIZE = 5;
    private final String name;

    public Name(String name) {
        validateEmptyName(name);
        validateOutOfNameLength(name);
        this.name = name;
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자일 수 없습니다.");
        }
    }

    private void validateOutOfNameLength(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("이름은 최소 1글자, 최대 5글자여야 합니다.");
        }
    }

    public String getName() {
        return name;
    }
}
