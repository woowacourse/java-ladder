package model;

public class Participant {
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Participant(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름은 null이거나 공백일 수 없다.");
        }
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 참여자 이름의 길이는 " + MAXIMUM_NAME_LENGTH
                    + "자를 초과할 수 없다.");
        }
    }

    public String getName() {
        return name;
    }
}
