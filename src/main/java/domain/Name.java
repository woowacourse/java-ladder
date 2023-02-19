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
        boolean isBlank = name.isBlank();
        boolean isInvalidLength = name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
        if (isBlank || isInvalidLength) {
            throw new IllegalArgumentException(Message.EXCEPTION_INVALID_NAME_LENGTH.message);
        }
    }

    protected enum Message {

        EXCEPTION_INVALID_NAME_LENGTH("%d글자 이상 %d글자 이하의 이름만 입력해주세요.", MIN_LENGTH, MAX_LENGTH);
        public static final String BASE_MESSAGE_FORMAT = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE_FORMAT, String.format(message, replaces));
        }
    }
}
