package domain;

import java.util.List;

class Gifts {
    private final List<Gift> gifts;

    private Gifts(List<Gift> gifts) {
        validateGiftsCount(gifts);
        this.gifts = gifts;
    }

    private void validateGiftsCount(List<Gift> players) {
        if (players == null || players.size() < 2 || players.size() > 10) {
            throw new IllegalStateException("상품은 2개 이상 10개 이하여야 합니다.");
        }
    }

    String getGiftName(int index) {
        Gift gift = gifts.get(index);
        return gift.name();
    }

    static Gifts of(List<String> giftsName) {
        List<Gift> gifts = giftsName.stream().map(Gift::new).toList();
        return new Gifts(gifts);
    }
}
