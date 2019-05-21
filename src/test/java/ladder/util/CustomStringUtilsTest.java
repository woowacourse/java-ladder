package ladder.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CustomStringUtilsTest {
    @Test
    void 한글자_이상_입력될_경우() {
        assertDoesNotThrow(() -> CustomStringUtils.checkIsBlank("a"));
    }

    @Test
    void Null_입력될_경우_예외_반환() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomStringUtils.checkIsBlank(null));
    }

    @Test
    void 빈문자열_입력될_경우_예외_반환() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomStringUtils.checkIsBlank(""));
    }

    @Test
    void 공백_입력될_경우_예외_반환() {
        assertThrows(IllegalArgumentException.class,
                () -> CustomStringUtils.checkIsBlank(" "));
    }
}
