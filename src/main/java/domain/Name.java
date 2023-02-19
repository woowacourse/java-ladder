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
        validateInvalidBlankName(name);
        validateInvalidateLengthName(name);
    }

    private void validateInvalidateLengthName(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(Message.EXCEPTION_INVALID_NAME_LENGTH.message);
        }
    }

    private void validateInvalidBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(Message.EXCEPTION_INVALID_NAME_BLANK.message);
        }
    }

    protected enum Message {

        EXCEPTION_INVALID_NAME_LENGTH("%d글자 이상 %d글자 이하의 이름만 입력해주세요.", MIN_LENGTH, MAX_LENGTH),
        EXCEPTION_INVALID_NAME_BLANK("빈 이름(공백)은 입력이 불가능합니다.");

        public static final String _FORMAT = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(_FORMAT, String.format(message, replaces));
        }
    }
}
