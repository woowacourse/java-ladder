package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class LadderHeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    @DisplayName("사다리 높이가 1 미만이면 예외를 던진다.")
    void should_ThrowException_When_ValueLessThan1(int value) {
        assertThatThrownBy(() -> new LadderHeight(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사다리 높이는 1 이상이어야 합니다.");
    }
}
