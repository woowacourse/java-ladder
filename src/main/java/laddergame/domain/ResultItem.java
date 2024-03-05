package laddergame.domain;

public record ResultItem(String item) {
    private static final String ITEM_BLANK_ERROR = "아이템을 입력해 주세요.";

    public ResultItem {
        validate(item);
    }

    private void validate(String item) {
        checkItemIsBlank(item);
    }

    private void checkItemIsBlank(final String item) {
        if (item.isBlank()) {
            throw new IllegalArgumentException(ITEM_BLANK_ERROR);
        }
    }
}
