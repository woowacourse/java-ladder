package domain;

public class Name {

    private final String name;

    public Name(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
        this.name = name;
    }
}
