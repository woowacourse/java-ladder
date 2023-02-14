package domain;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
