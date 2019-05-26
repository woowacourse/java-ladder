package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayersTest {
    @Test
    void 연속된_콤마_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Players("1,,3,4,5"));
    }

    @Test
    void 콤마로_시작되는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Players(",,3,4,5"));
    }

    @Test
    void 콤마로_끝나는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Players("1,2,3,4,"));
    }

    @Test
    void 중복된_이름이_있는_경우_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Players("1,1,3,4,5"));
    }
}
