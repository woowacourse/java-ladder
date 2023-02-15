package domain;


import java.util.Objects;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }


    private void validate(String name) {
        validateBlank(name);
        validateLength(name);
    }

    private void validateBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(String.format("이름은 공백이거나 비어있을 수 없습니다. 입력값 : %s", name));
        }
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(String.format("이름은 1글자 이상, 5글자 이하여야합니다. 입력값 : %s", name));
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
        Name ohterName = (Name) o;
        return name.equals(ohterName.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
