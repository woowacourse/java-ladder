package domain;

import java.util.Objects;

public class Name {
    private static final String NAME_STYLE = "^[가-힣a-zA-Z0-9_-]+$";

    private final String name;

    public Name (String inputName) {
        validateLength(inputName);
        validateStyle(inputName);
        this.name = inputName;
    }

    private void validateLength(String inputName) {
        if (inputName.length() < 1 || inputName.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1글자 이상 5글자 이하여야 합니다.");
        }
    }

    private void validateStyle(String inputName) {
        if (!inputName.matches(NAME_STYLE)){
            throw new IllegalArgumentException("이름은 한글, 영어, 숫자, '_', '-'로만 이루어져야 합니다.");
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
