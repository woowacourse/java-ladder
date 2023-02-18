package ladder.domain;

public class UserName {

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MINIMUM_NAME_LENGTH = 1;
    private static final String INVALID_LENGTH_MESSAGE = "유저 이름 길이는 공백이거나 " + MAX_NAME_LENGTH + " 초과일 수 없습니다.";
    private static final String COMMAND_ALL = "all";
    private static final String INVALID_USERNAME_COMMAND_ALL = "유저 이름은 " + COMMAND_ALL + " 일 수 없습니다.";

    private final String name;

    public UserName(String name) {

        name = name.trim();
        validate(name);
        this.name = name;
    }

    private void validate(String name) {

        validateLength(name);
        validateCommandAll(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH || name.length() < MINIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        }
    }

    private void validateCommandAll(String name) {
        if (name.equals(COMMAND_ALL)) {
            throw new IllegalArgumentException(INVALID_USERNAME_COMMAND_ALL);
        }
    }

    public String getName() {
        return name;
    }
}
