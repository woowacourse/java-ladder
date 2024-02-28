package laddergame.domain;

import java.util.List;

public class ResultItem {
    private static final String ITEM_BLANK_ERROR = "아이템을 입력해 주세요.";
    private final String item;

    public ResultItem(String item) {
        validate(item);
        this.item = item;
    }

    public void validate(String item) {
        checkItemIsBlank(item);
    }

    private void checkItemIsBlank(final String item) {
        if (item.isBlank()) {
            throw new IllegalArgumentException(ITEM_BLANK_ERROR);
        }
    }

    public String getItem() {
        return item;
    }
}
