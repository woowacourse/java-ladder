package domain;

public class Name {
    public Name(String name) {
        validate(name);
    }

    private static void validate(String name) {
        if ((name.isBlank() || name.length() > 5)) {
            throw new IllegalArgumentException();
        }
    }
}
