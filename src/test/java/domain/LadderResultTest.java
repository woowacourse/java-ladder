package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderResultTest {

    @Test
    @DisplayName("사다리 게임의 결과가 공백이면 예외를 던진다.")
    void throws_exception_when_input_empty() {
        // given
        String givenResult = "";

        // when & then
        assertThatThrownBy(() -> new LadderResult(givenResult))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임의 결과가 공백이 아니면 예외가 발생하지 않는다.")
    void throws_not_exception_when_input_not_empty() {
        // given
        String givenResult = "꽝";

        // when
        LadderResult ladderResult = new LadderResult(givenResult);

        // then
        assertThat(ladderResult.getResult()).isEqualTo(givenResult);
    }

    @ParameterizedTest
    @ValueSource(strings = {"꽝", "20", "300", "4000"})
    @DisplayName("사다리 게임의 결과의 길이를 반환한다.")
    void returns_length_of_ladder_result(String givenResult) {
        // given
        LadderResult givenLadderResult = new LadderResult(givenResult);

        // when
        int lengthOfResult = givenLadderResult.getLengthOfLadderResult();

        // then
        assertThat(lengthOfResult).isEqualTo(givenResult.length());
    }
}
