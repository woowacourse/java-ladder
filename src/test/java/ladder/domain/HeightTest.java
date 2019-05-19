package ladder.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class HeightTest {
    @Test
    void 높이_최소값_이하() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Height(0);
        });
    }
}
