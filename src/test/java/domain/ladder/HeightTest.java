package domain.ladder;

import domain.ladder.Height;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("사다리의 높이가 1이상 10 이하이면 높이가 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void validHeight(final int rawHeight) {
        //when & then
        Assertions.assertThatCode(() -> new Height(rawHeight))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리의 높이가 1미만 10 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void invalidHeight(final int rawHeight) {
        //when & then
        Assertions.assertThatThrownBy(() -> new Height(rawHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
