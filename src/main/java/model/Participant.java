package model;

public class Participant {
    private final int MAX_LENGTH = 5;
    private final String name;

    public Participant(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름은 null이거나 공백일 수 없다.");
        }
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름의 길이는 5자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }
}
