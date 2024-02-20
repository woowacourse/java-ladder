package ladder.model;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_PATTERN = "^[a-zA-Z0-9]*$";

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
        if (!isNameFormatValid(name)) {
            throw new IllegalArgumentException("이름은 영문자와 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isNameLengthLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isNameEmpty(String name) {
        return name.isEmpty();
    }

    private boolean isNameFormatValid(String name) {
        return name.matches(NAME_PATTERN);
    }
}
