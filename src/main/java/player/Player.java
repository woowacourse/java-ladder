package player;

import java.util.Objects;
import java.util.regex.Pattern;

public class Player {

    private static final Pattern NAME_REGEX = Pattern.compile("^[a-z]*$");
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    Player(String name) {
        validateNameLength(name);
        validateNamePattern(name);
        this.name = name;
    }

    String getName() {
        return name;
    }

    private static boolean isNameLengthOutOfRange(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    private void validateNameLength(String name) {
        if (name == null || isNameLengthOutOfRange(name)) {
            throw new IllegalArgumentException("이름은 1글자 이상 5글자 이하로 작성해야 합니다.");
        }
    }

    private void validateNamePattern(String name) {
        boolean isPatternMatched = NAME_REGEX.matcher(name).matches();
        if (!isPatternMatched) {
            throw new IllegalArgumentException("이름은 알파벳 소문자로만 작성해야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Player player = (Player) o;

        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
