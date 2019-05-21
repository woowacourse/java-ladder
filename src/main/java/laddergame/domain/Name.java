package laddergame.domain;

import java.util.Objects;

public class Name {
    private String name;

    public Name(String name) {
        checkConditionsForName(name);
        this.name = name;
    }

    private static void checkConditionsForName(String name) {
        checkNameLength(name);
    }

    private static void checkNameLength(String name) {
        if (name.isEmpty() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Name name1 = (Name) o;
        return Objects.equals(name, name1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
