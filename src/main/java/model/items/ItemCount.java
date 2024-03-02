package model.items;

import model.Count;
import model.people.PersonCount;

public class ItemCount extends Count  {
    private ItemCount(final int rawCount) {
        super(rawCount);
    }

    @Override
    protected void validateCount(final int rawCount) {
    }

    public static ItemCount of(final int rawItemsCount, final PersonCount personCount) {
        validateItemsCount(rawItemsCount, personCount);
        return new ItemCount(rawItemsCount);
    }

    private static void validateItemsCount(final int rawItemsCount, final PersonCount personCount) {
        if (personCount.isNotEqual(rawItemsCount)) {
            throw new IllegalArgumentException("참여 인원 수와 결과 목록의 수가 동일하지 않습니다.");
        }
    }
}
