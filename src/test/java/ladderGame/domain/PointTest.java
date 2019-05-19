package ladderGame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PointTest {
    @Test
    void 생성_오류() {
        assertThrows(IllegalArgumentException.class, () -> {
           new Point(true, true);
        });
    }
}
