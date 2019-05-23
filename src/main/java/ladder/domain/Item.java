package ladder.domain;

import java.util.Objects;

public class Item {
    private static final int MINIMUM_LENGTH_OF_ITEM = 1;

    private final String item;

    public Item(String item) {
        validateLength(item.trim());
        this.item = item;
    }

    private void validateLength(String item) {
        if (item.length() < MINIMUM_LENGTH_OF_ITEM) {
            throw new IllegalArgumentException("실행 결과를 바르게 입력해 주세요.");
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
        return item;
    }
}
