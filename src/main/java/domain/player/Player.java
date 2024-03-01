package domain.player;

import java.util.regex.Pattern;

public class Player {
    private static final int MINIMUM_NAME_LENGTH = 2;
    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final Pattern PLAYER_NAME_PATTERN = Pattern.compile("^[a-zA-Z가-힣\\d]+$");
    private static final String NAME_LENGTH_EXCEPTION_MESSAGE = "[ERROR] 잘못된 이름: %s - 이름의 길이는 %d ~ %d 글자여야 합니다.";
    private static final String NAME_PATTERN_EXCEPTION_MESSAGE = "[ERROR] 잘못된 이름: %s - 이름은 한글, 영문자만 가능합니다.";

    private final String name;

    public Player(String name) {
        validateLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() < MINIMUM_NAME_LENGTH || MAXIMUM_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(
                    String.format(NAME_LENGTH_EXCEPTION_MESSAGE, name, MINIMUM_NAME_LENGTH, MAXIMUM_NAME_LENGTH)
            );
        }
    }

    private void validateNamePattern(String name) {
        if (!PLAYER_NAME_PATTERN.matcher(name).matches()) {
            throw new IllegalArgumentException(
                    String.format(NAME_PATTERN_EXCEPTION_MESSAGE, name)
            );
        }
    }

    public int getNameLength() {
        return this.name.length();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Player other) {
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
