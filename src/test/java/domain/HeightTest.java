package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class HeightTest {
    @Test
    @DisplayName("사다리 높이는 1 이상의 정수여야 한다.")
    void isHeightPositiveInteger() {
        int invalidHeight = 0;
        int validHeight = 1;

        assertThrows(IllegalArgumentException.class, () -> new Height(invalidHeight));
        assertDoesNotThrow(() -> new Height(validHeight));
    }

    @Test
    @DisplayName("사다리 높이를 반환한다.")
    void getLadderHeight() {
        int rawHeight = 10;
        Height height = new Height(rawHeight);

        assertEquals(rawHeight, height.getValue());
    }
}
