package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -100})
    @DisplayName("높이가 1미만이면 예외가 발생한다.")
    void givenUnderOneHeight_thenFail(int input) {
        //then
        assertThatThrownBy(() -> new Height(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최소 높이가 1이상이어야 합니다.");
    }


}
