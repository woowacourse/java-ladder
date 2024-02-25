package ladder.model;

import java.util.Objects;

public class Player {
    private static final int MAX_NAME_LENGTH = 5;
    private static final String NAME_PATTERN = "^[a-zA-Z0-9]*$";

    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (isNameLengthNotValid(name)) {
            throw new IllegalArgumentException("이름의 길이는 1이상 5이하의 숫자여야 합니다.");
        }
        if (isNameFormatNotValid(name)) {
            throw new IllegalArgumentException("이름은 영문자와 숫자로 구성되어야 합니다.");
        }
    }

    private boolean isNameLengthNotValid(String name) {
        return name.isEmpty() || name.length() > MAX_NAME_LENGTH;
    }

    private boolean isNameFormatNotValid(String name) {
        return !name.matches(NAME_PATTERN);
    }

    public boolean isNameAll() {
        return name.equals("all");
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Player player = (Player) o;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
