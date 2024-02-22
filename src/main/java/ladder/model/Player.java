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
            throw new IllegalArgumentException("이름의 길이는 5보다 클 수 없다.");
        }
        if (isNameEmpty(name)) {
            throw new IllegalArgumentException("이름의 길이는 1보다 작을 수 없다.");
        }
        if (isNameFormatNotValid(name)) {
            throw new IllegalArgumentException("이름은 영문자와 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isNameLengthLongerThanMaxLength(String name) {
        return name.length() > MAX_NAME_LENGTH;
    }

    private boolean isNameEmpty(String name) {
        return name.isEmpty();
    }

    private boolean isNameFormatNotValid(String name) {
        return !name.matches(NAME_PATTERN);
    }

    public String getName() {
        return name;
    }
}
