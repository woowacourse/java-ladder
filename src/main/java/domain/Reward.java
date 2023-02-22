package domain;

public class Reward {

    private final Name name;

    public Reward(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getName();
    }
}
