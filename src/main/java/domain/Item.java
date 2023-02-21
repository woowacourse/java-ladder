package domain;

import java.util.Objects;

public class Item {
    private static final String INVALID_ITEM_BLANK_MESSAGE = "실행 결과는 공백으로만 이루어지면 안됩니다.";
    private static final String INVALID_ITEM_LENGTH_MESSAGE = "실행 결과는 1~5 글자만 가능합니다.";
    private static final int ITEM_MIN_LENGTH = 1;

    private final String item;

    public Item(String item) {
        validateItemLength(item);
        validateBlankItem(item);
        this.item = item;
    }

    public String getItem() {
        return item;
    }

    private void validateBlankItem(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(INVALID_ITEM_BLANK_MESSAGE);
        }
    }

    private void validateItemLength(String name) {
        if (ITEM_MIN_LENGTH > name.length()) {
            throw new IllegalArgumentException(INVALID_ITEM_LENGTH_MESSAGE);
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
