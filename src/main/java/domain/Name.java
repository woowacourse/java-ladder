package domain;

import java.util.Objects;

public class Name {
    private static final Integer MIN_LENGTH = 1;
    private static final Integer MAX_LENGTH = 5;

    private final String name;

    public Name(String name) {
        validateLength(name);
        this.name = name;
    }

    private void validateLength(String name) {
        if (isInvalidLengthName(name)) {
            throw new IllegalArgumentException("[ERROR] 이름의 길이는 " + MIN_LENGTH + "자에서 " + MAX_LENGTH + "자 사이여야 합니다");
        }
    }

    private boolean isInvalidLengthName(String name) {
        return name.length() < MIN_LENGTH || name.length() > MAX_LENGTH;
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
