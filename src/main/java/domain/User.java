package domain;

public class User {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_LENGTH_ERROR_MESSAGE =
            "[ERROR] 사람 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "글자로 입력해 주세요.";
    public static final String NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 사람 이름은 영문자만 가능합니다.";

    private final String name;

    public User(String name) {
        validateNameLength(name);
        validateNameFormat(name);
        this.name = convertName(name);
    }

    private void validateNameLength(String name) {
        if (isValidLength(name)) {
            throw new IllegalArgumentException(NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private boolean isValidLength(String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    private void validateNameFormat(String name) {
        if (!name.matches("^[a-zA-z]*$")) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    private String convertName(String name) {
        if (name.length() == MAX_NAME_LENGTH) {
            return name;
        }
        return insertBlank(name);
    }

    private String insertBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name + " ");
        while (nameBuilder.length() < MAX_NAME_LENGTH) {
            nameBuilder.insert(0, " ");
        }
        return nameBuilder.toString();
    }
}
