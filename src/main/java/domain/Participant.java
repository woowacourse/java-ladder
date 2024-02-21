package domain;

public class Participant {

    private static final Integer MAX_NAME_LENGTH = 5;
    private final String name;

    public Participant(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
