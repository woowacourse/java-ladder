package domain;

public class Name {
    private final String name;

    public Name(String value) {
        validateNameLength(value);
        this.name = value;
    }

    private void validateNameLength(String value) {
        if (value.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
