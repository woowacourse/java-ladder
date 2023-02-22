package domain;

public class Player {

    private final Name name;

    public Player(final String name) {
        this.name = new Name(name);
    }

    public boolean hasSameName(final Name name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name.getName();
    }
}
