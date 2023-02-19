package domain;

import java.util.Objects;

public class Item {
    private static final String INVALID_NAME_BLANK_MESSAGE = "이름은 공백으로만 이루어지면 안됩니다.";
    private final String item;

    public Item(String item) {
        validateBlankName(item);
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    private void validateBlankName(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_NAME_BLANK_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item1 = (Item) o;
        return Objects.equals(item, item1.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }

    @Override
    public String toString() {
        return "Item{" +
                "item='" + item + '\'' +
                '}';
    }
}
