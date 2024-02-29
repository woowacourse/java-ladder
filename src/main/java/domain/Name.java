package domain;

import java.util.Objects;

public class Name {
    private static final String NAME_STYLE = "^[a-zA-Z0-9_-]+$";
    private static final int MAX_LENGTH = 5;

    private final String name;

    public Name (String inputName) {
        validateLength(inputName);
        validateStyle(inputName);
        this.name = inputName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Name name1 = (Name) obj;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    private void validateLength(String inputName) {
        if (inputName.isEmpty() || inputName.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(String.format("\"%s\"는 올바른 이름이 아닙니다. 이름의 길이는 1글자 이상 %d글자 이하여야 합니다.", inputName, MAX_LENGTH));
        }
    }

    private void validateStyle(String inputName) {
        if (!inputName.matches(NAME_STYLE)) {
            throw new IllegalArgumentException(String.format("\"%s\"는 올바른 이름이 아닙니다. 이름은 영어, 숫자, '_', '-'로만 이루어져야 합니다.", inputName));
        }
    }

    public String getName() {
        return name;
    }
}
