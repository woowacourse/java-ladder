package calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PositiveTest {
    @Test
    void 음수값_예외() {
        assertThrows(RuntimeException.class, () -> {
            new Positive("-1");
        });
    }

    @Test
    void 문자열_예외() {
        assertThrows(RuntimeException.class, () -> {
            new Positive("a");
        });
    }
}