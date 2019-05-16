package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 플레이어_이름_글자수_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("123456", 0, 3));
    }

    @Test
    void 플레이어_이름_글자수_미만_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("", 0, 3));
    }

    @Test
    void 플레이어_이름_널_테스트() { assertThrows(IllegalArgumentException.class, () -> new Player(null, 0, 3)); }

    @Test
    void 플레이어_위치_테스트() { assertThrows(IllegalArgumentException.class, () -> new Player("pobi", 4, 4)); }
}
