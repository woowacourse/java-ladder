package ladder.domain;

public class Item {
    private final String item;

    public Item(String item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return item;
    }
}
