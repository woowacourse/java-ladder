package domain;

public class Name {
    public Name(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() < 1 || name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
