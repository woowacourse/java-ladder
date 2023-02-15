package domain;


public class PersonNumber {
    public static final int MIN_RANGE = 2;
    public static final int MAX_RANGE = 100;
    private final int personNumber;

    public PersonNumber(int personNumber) {
        validate(personNumber);
        this.personNumber = personNumber;
    }

    public int getPersonNumber() {
        return personNumber;
    }

    private static void validate(int personNumber) {
        if (personNumber < MIN_RANGE || personNumber > MAX_RANGE) {
            throw new IllegalArgumentException(Message.EXCEPTION_RANGE.message);
        }
    }

    private enum Message {
        EXCEPTION_RANGE("%d 이상 %d 이하의 자연수만 입력해 주세요.", MIN_RANGE, MAX_RANGE);

        public static final String BASE_MESSAGE = "[ERROR] %s";
        private final String message;

        Message(String message, Object... replaces) {
            this.message = String.format(BASE_MESSAGE, String.format(message, replaces));
        }
    }
}
