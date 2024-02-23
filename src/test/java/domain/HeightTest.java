package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("사다리의 높이가 0이상 10 이하이면 높이가 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void validHeight(final int rawHeight) {
        //when
        final Height height = new Height(rawHeight);
        // then
        Assertions.assertThat(height.getValue()).isEqualTo(rawHeight);
    }

    @DisplayName("사다리의 높이가 0미만 10 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void invalidHeight(final int rawHeight) {
        //when & then
        Assertions.assertThatThrownBy(() -> new Height(rawHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
