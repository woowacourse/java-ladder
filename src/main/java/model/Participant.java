package model;

public class Participant {
    private final String name;

    public Participant(final String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
