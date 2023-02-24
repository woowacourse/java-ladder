package ladder.domain;

public class Product {

    private final Name name;

    public Product(final String name) {
        this.name = new Name(name);
    }

    public String getName() {
        return name.getValue();
    }
}
