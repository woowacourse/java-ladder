package laddergame.domain;

import java.util.Objects;

public class Name {

    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(final String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백은 이름이 될 수 없습니다.");
        }

        if (isOutOfRange(name)) {
            throw new IllegalArgumentException("1이상 5글자 이하의 이름을 입력해 주세요.");
        }
    }

    private static boolean isOutOfRange(final String name) {
        return name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }

    public int getNameLength() {
        return this.name.length();
    }
}
