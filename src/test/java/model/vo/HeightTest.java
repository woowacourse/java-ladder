package model.vo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeightTest {
    @Test
    void 사다리_높이는_1_미만이면_예외가_발생한다() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Height(0)),
                () -> assertDoesNotThrow(() -> new Height(1))
        );
    }
}
