package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WinningResultTest {

    @ParameterizedTest
    @ValueSource(strings = {"", "123456"})
    @DisplayName("결과 글자 수가 1글자 미만, 5글자 초과면 예외가 발생한다")
    void createNameWithWrongLength(String result) {
        //given
        //when
        //then
        assertThatThrownBy(() -> new WinningResult(result))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "12345"})
    @DisplayName("결과 글자 수가 1글자 이상, 5글자 이하면 정상 생성된다")
    void createNameWithCorrectLength(String result) {
        //given
        //when
        WinningResult winningResult = new WinningResult(result);

        //then
        assertThat(winningResult.getResult()).isEqualTo(result);
    }

}