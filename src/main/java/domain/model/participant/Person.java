package domain.model.participant;

import java.util.Objects;

public class Person {
    private static final int SIZE_LIMIT = 5;
    private final String name;

    public Person(final String name) {
        validateNameLength(name);
        validateNonBlank(name);
        validateNamedAll(name);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    private void validateNameLength(String name) {
        if (name.length() > SIZE_LIMIT) {
            throw new IllegalStateException("이름은 5글자 이하입니다.");
        }
    }

    private void validateNonBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("공백 이름은 허용하지 않습니다.");
        }
    }

    private void validateNamedAll(String name) {
        if (name.equals("all")) {
            throw new IllegalArgumentException("all이란 이름은 허용하지 않습니다.");
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)) {
            return false;
        }
        Person person = (Person) obj;
        return person.getName().equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
