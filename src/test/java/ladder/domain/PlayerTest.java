package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayerTest {
    @Test
    void 플레이어_이름_글자수_초과_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("123456"));
    }

    @Test
    void 플레이어_이름_글자수_미만_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void 플레이어_이름이_ALL_일때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> new Player("ALL"));
    }
}
