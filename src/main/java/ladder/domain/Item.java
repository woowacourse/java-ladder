package ladder.domain;

public class Item {
    
    private final Name name;

    public Item(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getValue();
    }
}
