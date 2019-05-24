package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeightTest {
    @Test
    void 생성자_최저값보다_작을때() {
        assertThrows(IllegalArgumentException.class, () -> Height.create(Height.MIN_HEIGHT - 1));
    }

}