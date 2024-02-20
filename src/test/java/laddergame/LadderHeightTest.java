package laddergame;

import laddergame.domain.LadderHeight;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderHeightTest {

    @DisplayName("사다리 높이가 양수가 아닐시 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void notPositive(int value) {
        Assertions.assertThatThrownBy(() -> new LadderHeight(value))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 입력값은 양수만 가능합니다.");
    }

    @DisplayName("사다리 높이가 양수면 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 100})
    void create(int value) {
        // given & when
        final LadderHeight ladderHeight = new LadderHeight(value);

        // then
        Assertions.assertThat(ladderHeight.getValue()).isEqualTo(value);

    }
}
