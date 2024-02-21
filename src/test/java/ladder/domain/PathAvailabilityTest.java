package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathAvailabilityTest {
    @Test
    @DisplayName("사다리 경로 형태를 올바르게 반환한다.")
    void getPathAvailabilityShapeTest() {
        // when & then
        assertEquals("     ", PathAvailability.EMPTY.getShape());
        assertEquals("-----", PathAvailability.EXIST.getShape());
    }
}
