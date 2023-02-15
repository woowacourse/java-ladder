package ladder.domain;

public class Player {
    private static final int MAX_SIZE = 6;
    private final String name;

    public Player(String name) {
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
        if(name.length() >= MAX_SIZE) {
            throw new IllegalArgumentException("이름은 최소 1글자, 최대 5글자여야 합니다.");
        }
    }
}
