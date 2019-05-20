package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    void 생성자_null입력() {
        assertThrows(IllegalArgumentException.class, () -> new Player(null));
    }

    @Test
    void 생성자_빈문자열() {
        assertThrows(IllegalArgumentException.class, () -> new Player(""));
    }

    @Test
    void 생성자_글자수_초과() {
        assertThrows(IllegalArgumentException.class, () -> new Player("123456"));
    }
}