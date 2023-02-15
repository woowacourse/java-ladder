package ladder.domain;

public class User {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final String INVALID_LENGTH_MESSAGE = "유저 이름 길이는 공백이거나 6 이상일 수 없습니다.";
    private final String name;

    public User(String name) {
        validate(name);

        this.name = name;
    }

    private void validate(String name) {
        validateLength(name.trim());
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }
}
