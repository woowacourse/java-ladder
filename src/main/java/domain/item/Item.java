package domain.item;

public class Item {

    private static final int MIN_ITEM_LENGTH = 1;
    private static final int MAX_ITEM_LENGTH = 5;
    private static final String SPACE = " ";

    private final String item;

    public Item(String item) {
        validate(item);
        this.item = item;
    }

    private void validate(String item) {
        validateLength(item);
        validateSpace(item);
    }

    private void validateLength(String item) {
        if (item.length() < MIN_ITEM_LENGTH || item.length() > MAX_ITEM_LENGTH) {
            throw new IllegalArgumentException("실행 결과의 길이는 1이상 5이하만 가능합니다.");
        }
    }

    private void validateSpace(String name) {
        if (name.contains(SPACE)) {
            throw new IllegalArgumentException("실행 결과에는 공백이 들어갈 수 없습니다.");
        }
    }

    public String getItem() {
        return item;
    }
}
