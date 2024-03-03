package domain;

import java.util.Objects;

public class Player {

    public static final String ALL = "all";
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateLength(name);
        validateCharacter(name);
        validateNameRule(name);
    }

    private void validateNameRule(String name) {
        if (ALL.equals(name)) {
            throw new IllegalArgumentException("플레이어의 이름으로 all은 입력할 수 없습니다.");
        }
    }

    private void validateCharacter(String name) {
        if (isAlphabet(name)) {
            throw new IllegalArgumentException(String.format("이름은 영어만 가능합니다. 입력한 이름:%s", name));
        }
    }

    private boolean isAlphabet(String name) {
        return name.chars().noneMatch(character -> isUpperCase(character) || isLowerCase(character));
    }

    private boolean isUpperCase(int character) {
        return 'A' <= character && character <= 'Z';
    }

    private boolean isLowerCase(int character) {
        return 'a' <= character && character <= 'z';
    }

    private void validateLength(String name) {
        if (name == null || name.isBlank() || name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException(
                    String.format("1글자 이상 %d글자 이하의 이름만 입력하세요. 입력한 이름: %s", MAXIMUM_NAME_LENGTH, name));
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Player player)) {
            return false;
        }
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
