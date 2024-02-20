package domain;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HeightTest {

    @Test
    @DisplayName("사다리 높이는 1 이상의 정수여야 한다.")
    void isHeightPositiveInteger() {
        int inputValue = 0;
        assertThrows(IllegalArgumentException.class, () -> new Height(inputValue));
    }
}
