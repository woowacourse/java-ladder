package domain;

import java.util.Objects;
import java.util.regex.Pattern;

public class Name {

    private final String name;


    public Name(final String name) {
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException("이름의 길이는 1 ~ 5 자 이어야 합니다.");
        }

        if (!Pattern.matches("^[a-zA-Z0-9]+", name)) {
            throw new IllegalArgumentException("이름이 영어와 숫자가 아니라면 예외가 발생한다");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
