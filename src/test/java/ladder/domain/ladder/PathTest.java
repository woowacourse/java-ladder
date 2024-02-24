package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {
    @Test
    @DisplayName("사다리 경로 형태를 올바르게 반환한다.")
    void getPathAvailabilityShapeTest() {
        // when & then
        assertThat(Path.EMPTY.getShape()).isEqualTo("     ");
        assertThat(Path.EXIST.getShape()).isEqualTo("-----");
    }

    @Test
    @DisplayName("boolean을 입력받으면 올바른 타입의 Path를 반환한다.")
    void convertPathAvailabilityTest() {
        // when & then
        assertThat(Path.from(false)).isEqualTo(Path.EMPTY);
        assertThat(Path.from(true)).isEqualTo(Path.EXIST);
    }
}
