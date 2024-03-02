package domain.ladder;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class HeightTest {

    @DisplayName("사다리의 높이가 1이상 10 이하이면 높이가 잘 생성된다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 10})
    void validHeight(final int rawHeight) {
        //when & then
        assertThatCode(() -> new Height(rawHeight))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리의 높이가 1미만 10 초과이면 예외를 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 11})
    void invalidHeight(final int rawHeight) {
        //when & then
        assertThatThrownBy(() -> new Height(rawHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
