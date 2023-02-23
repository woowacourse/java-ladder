package ladder.domain;

public class Name {
    private static final int MAX_SIZE = 5;
    private static final String GAME_COMMAND = "all";
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateEmpty(name);
        validateOutOfLengthRange(name);
        validateGameCommand(name);
    }

    private void validateEmpty(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 문자일 수 없습니다.");
        }
    }

    private void validateOutOfLengthRange(String name) {
        if (name.length() > MAX_SIZE) {
            throw new IllegalArgumentException("이름은 최소 1글자, 최대 5글자여야 합니다.");
        }
    }

    private void validateGameCommand(String name) {
        if(name.equals(GAME_COMMAND)) {
            throw new IllegalArgumentException("all이라는 이름을 쓸 수 없습니다.");
        }
    }

    public String getValue() {
        return name;
    }
}
