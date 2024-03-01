package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PathTest {
    @Test
    @DisplayName("boolean을 입력받으면 올바른 타입의 Path를 반환한다.")
    void convertPathAvailabilityTest() {
        // when & then
        assertThat(Path.from(false)).isEqualTo(Path.EMPTY);
        assertThat(Path.from(true)).isEqualTo(Path.EXIST);
    }
}
