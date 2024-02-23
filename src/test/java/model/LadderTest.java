package model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.vo.Height;
import org.junit.jupiter.api.Test;

public class LadderTest {
    @Test
    void 사다리_높이는_1_미만이면_예외가_발생한다() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> new Height(0)),
                () -> assertDoesNotThrow(() -> new Height(1))
        );
    }
}
