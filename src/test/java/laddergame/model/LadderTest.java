package laddergame.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @Test
    @DisplayName("사다리 생성 테스트")
    void Should_Success_When_MakeLadder() {
        int height = 4;
        int personCount = 3;
        assertDoesNotThrow(() -> new Ladder(new Height(height), personCount));
    }

    @Test
    @DisplayName("사다리가 높이만큼 선을 생성하는지 테스트")
    void Should_EqualTo_When_MakeLadder() {
        int height = 4;
        int personCount = 3;
        assertThat(new Ladder(new Height(height), personCount).getSize()).isEqualTo(height);
    }
}
