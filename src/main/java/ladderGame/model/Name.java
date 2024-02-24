package ladderGame.model;

public class Name {
    private static final String EXCEPTION_MESSAGE_OVER_THAN_MAXIMUM = "이름은 최대 5글자까지 가능합니다.";
    private static final String EXCEPTION_MESSAGE_NOT_BLANK = "이름은 공백일 수 없습니다.";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_OVER_THAN_MAXIMUM);
        }
        if (name.isBlank()) {
            throw new IllegalArgumentException(EXCEPTION_MESSAGE_NOT_BLANK);
        }
    }

    public String getName() {
        return name;
    }
}
