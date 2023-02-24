package model;

import java.util.Objects;

public class Name {

    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateBlank(name);
        validateLength(name);
        validateCommand(name);

        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지만 가능합니다.");
        }
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름은 공백일 수 없습니다.");
        }
    }

    private void validateCommand(String name) {
        if (!LadderGameCommand.ALL_RESULT_PRINT_AND_EXIT_COMMAND.isPlayable(name)) {
            throw new IllegalArgumentException("all은 사용할 수 없는 이름입니다.");
        }
    }

    public boolean matchesByName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object target) {
        if (this == target) {
            return true;
        }
        if (!(target instanceof Name)) {
            return false;
        }
        Name targetName = (Name) target;
        return Objects.equals(this.name, targetName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
