package domain;

public class Name {

    private static final int MIN_LENGTH = 1;
    private static final int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_NAME_LENGTH.message);
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(Message.EXCEPTION_NAME_BLANK.message);
        }
    }

    private enum Message {

        EXCEPTION_NAME_LENGTH("%d글자 이상 %d글자 이하의 이름만 입력해주세요.", MIN_LENGTH, MAX_LENGTH),
        EXCEPTION_NAME_BLANK("빈 이름(공백)은 입력이 불가능합니다.");

        public static final String BASE_MESSAGE = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
        }
    }
}
