package model;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.isBlank() || name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
