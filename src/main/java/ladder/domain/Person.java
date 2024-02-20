package ladder.domain;

import java.util.Objects;

public class Person {

    String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        int length = name.length();
        if (length < 1 || length > 5) {
            throw new IllegalArgumentException("이름은 1~5글자 이내입니다.");
        }
    }

    @Override
    public boolean equals(Object object) {
        return object instanceof Person other
                && Objects.equals(name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
