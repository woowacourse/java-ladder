package domain;

import exception.InvalidPersonNameException;
import util.StringUtil;

import java.util.Objects;

public class Person {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Person(String name) {
        validateName(name);
        name = name.trim();
        this.name = name;
    }

    private void validateName(String name) {
        if (isValidLength(name)) {
            throw new InvalidPersonNameException();
        }
    }

    private boolean isValidLength(String name) {
        return StringUtil.isNullOrBlank(name) || name.trim().length() > MAX_NAME_LENGTH;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name;
    }
}
