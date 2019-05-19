package laddergame.domain;

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
}
