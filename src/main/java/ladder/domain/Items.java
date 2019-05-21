package ladder.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Item들이 모여있는 클래스
 *
 * @author heebg
 * @version 1.0 2019-05-18
 */
public class Items implements Iterable<Item> {
    private static final String EX_OUTPUT_SAME_SIZE = "이전에 입력한 사용자 이름과 개수가 일치하지 않습니다.";
    private static final String SIGN_SEPARATOR = ",";

    private final List<Item> items;

    private Items(List<Item> items) {
        this.items = items;
    }

    /**
     * 생성자
     *
     * @param names   아이템 이름들
     * @param rowSize 아이템 개수들
     * @return Items
     */
    public static Items newInstance(String names, int rowSize) {
        List<Item> items = new ArrayList<>();
        for (String name : names.split(SIGN_SEPARATOR)) {
            items.add(Item.newInstance(name));
        }
        ThrowException.checkArgument(items.size() != rowSize, EX_OUTPUT_SAME_SIZE);
        return new Items(items);
    }

    /**
     * Items 크기
     *
     * @return size
     */
    public int size() {
        return items.size();
    }

    /**
     * index번 째 Item 반환
     *
     * @param index 위치
     * @return Item
     */
    public Item get(int index) {
        return items.get(index);
    }

    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Items that = (Items) o;
        return Objects.equals(items, that.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(items);
    }
}
