package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PathTest {
    @Test
    @DisplayName("사다리 경로 형태를 올바르게 반환한다.")
    void getPathAvailabilityShapeTest() {
        // when & then
        assertEquals("     ", Path.EMPTY.getShape());
        assertEquals("-----", Path.EXIST.getShape());
    }

    @Test
    @DisplayName("boolean을 입력받으면 올바른 타입의 Path를 반환한다.")
    void convertPathAvailabilityTest() {
        // when & then
        assertEquals(Path.EMPTY, Path.from(false));
        assertEquals(Path.EXIST, Path.from(true));
    }
}
