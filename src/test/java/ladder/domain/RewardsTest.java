package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class RewardsTest {
    @Test
    void 연속된_콤마_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rewards("1,,3,4,5"));
    }

    @Test
    void 콤마로_시작되는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rewards(",,3,4,5"));
    }

    @Test
    void 콤마로_끝나는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Rewards("1,2,3,4,"));
    }
}
