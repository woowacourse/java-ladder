package domain;

import java.util.Arrays;
import java.util.List;

class Gifts {
    private final List<Gift> gifts;

    private Gifts(List<Gift> gifts) {
        this.gifts = gifts;
    }

    static Gifts of(String... giftsName) {
        List<Gift> gifts = Arrays.stream(giftsName).map(Gift::new).toList();
        return new Gifts(gifts);
    }
}
