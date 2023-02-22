package domain.model;

import domain.vo.Name;

import java.util.List;

public class Goods {
    private static final String NOT_SAME_COUNT_ERROR = "참가자 수와 상품 수가 같아야 합니다.";
    private final List<Name> items;
    private final int playerCounts;

    public Goods(List<Name> items, int playerCounts) {
        this.items = items;
        this.playerCounts = playerCounts;
        validate();
    }

    public String get(int index) {
        return items.get(index).get();
    }

    public List<Name> getGoodsNames() {
        return items;
    }

    private void validate() {
        if (items.size() != playerCounts) {
            throw new IllegalArgumentException(NOT_SAME_COUNT_ERROR);
        }
    }

    public Name getItemsWithPosition(final int position) {
        return items.get(position);
    }
}
