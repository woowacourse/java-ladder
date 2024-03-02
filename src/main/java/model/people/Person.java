package model.people;

import java.util.Objects;
import model.Name;

public class Person {
    private final Name name;

    public Person(final String rawName) {
        this.name = new PersonName(rawName);
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public String getName() {
        return name.getName();
    }
}
