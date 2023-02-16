package ladder.domain;

public class Player {
    private static final int MAX_SIZE = 6;
    private final String name;
    private final StartPoint position;

    public Player(String name, int startPoint) {
        validateEmptyName(name);
        validateOutOfNameLength(name);
        this.name = name;
        this.position = new StartPoint(startPoint);
    }

    public String getName() {
        return name;
    }

    private void validateEmptyName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자일 수 없습니다.");
        }
    }

    private void validateOutOfNameLength(String name) {
        if (name.length() >= MAX_SIZE) {
            throw new IllegalArgumentException("이름은 최소 1글자, 최대 5글자여야 합니다.");
        }
    }
}
