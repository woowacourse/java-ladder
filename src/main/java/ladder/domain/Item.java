package ladder.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * 사다리 타기 실행 결과 아이템 클래스
 * <br> Item item = Item.newBuilder("pass")
 *
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Item {
    private static final int CNT_MIN_OUTPUT_RANGE = 1;
    private static final int CNT_MAX_OUTPUT_RANGE = 5;
    private static final String EX_OUTPUT_LENGTH = "실행 결과는 " + CNT_MIN_OUTPUT_RANGE + "글자~" + CNT_MAX_OUTPUT_RANGE + "글자 사이로 입력해야합니다.";

    private final String item;

    private Item(String item) {
        this.item = checkCondition(item);
    }

    /**
     * 생성자
     *
     * @param item 실행 결과 아이템
     * @return Item
     */
    public static Item newBuilder(String item) {
        return new Item(item);
    }

    private String checkCondition(String item) {
        item = item.trim();
        makeThrow(StringUtils.isBlank(item), EX_OUTPUT_LENGTH);
        makeThrow(item.length() > CNT_MAX_OUTPUT_RANGE, EX_OUTPUT_LENGTH);
        return item;
    }

    private void makeThrow(boolean state, String message) {
        if (state) {
            throw new IllegalArgumentException(message);
        }
    }

    @Override
    public String toString() {
        return item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(this.item, item.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(item);
    }
}
