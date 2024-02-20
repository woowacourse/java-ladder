package ladder.model;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Player(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        if (isNameLengthLongerThanMaxLength(name)) {
            throw new IllegalArgumentException("이름의 길이는 5를 초과할 수 없다.");
        }

        if (isNameEmpty(name)) {
            throw new IllegalArgumentException("이름이 비어 있습니다.");
        }
    }

    private boolean isNameLengthLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isNameEmpty(String name) {
        return name.isEmpty();
    }
}
