package domain.user;

import domain.ladder.Line;
import java.util.List;

public class User {
    private static final int MIN_NAME_LENGTH = 1;
    public static final int MAX_NAME_LENGTH = 5;
    public static final String NAME_LENGTH_ERROR_MESSAGE =
            "[ERROR] 사람 이름은 " + MIN_NAME_LENGTH + "~" + MAX_NAME_LENGTH + "글자로 입력해 주세요.";
    public static final String NAME_FORMAT_ERROR_MESSAGE = "[ERROR] 사람 이름은 영문자만 가능합니다.";
    private static final String NAME_REGEX_FORMAT = "^[a-zA-z]*$";

    private final String name;
    private int position;

    public User(String name, int position) {
        validateNameLength(name);
        validateNameFormat(name);
        this.name = name;
        this.position = position;
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
        if (!name.matches(NAME_REGEX_FORMAT)) {
            throw new IllegalArgumentException(NAME_FORMAT_ERROR_MESSAGE);
        }
    }

    public String getName() {
        return name;
    }

    public void movePosition(Line nextLine) {
        List<Boolean> nextLineValues = nextLine.getLine();
        if (nextLineValues.get(position)) {
            this.position--;
        }
        else if (position + 1 < nextLineValues.size() && nextLineValues.get(position + 1)) {
            this.position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
