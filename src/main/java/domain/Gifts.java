package domain;

import java.util.Arrays;
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

    static Gifts of(String... giftsName) {
        List<Gift> gifts = Arrays.stream(giftsName).map(Gift::new).toList();
        return new Gifts(gifts);
    }
}
