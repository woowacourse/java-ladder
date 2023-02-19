package domain;

public class User {
    private final Name name;

    public User(Name name) {
        this.name = name;
    }

    public String getName() {
        return name.getName();
    }
}
