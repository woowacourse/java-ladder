package ladder.domain.outcome;

import ladder.exception.outcome.InvalidOutcomeLengthException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OutcomeTest {
    @Test
    @DisplayName("실행 결과의 앞뒤 공백을 제거한다.")
    void trimOutcomeTest() {
        // given
        final String value = " 꽝 ";
        final String expectedValue = "꽝";

        // when
        final Outcome outcome = new Outcome(value);

        // then
        assertThat(outcome.value())
                .isEqualTo(expectedValue);
    }

    @ParameterizedTest
    @ValueSource(strings = {"12345", "", "꽝꽝꽝꽝꽝꽝꽝", "  "})
    @DisplayName("실행 결과의 값이 1에서 4자 사이가 아니면 예외가 발생한다.")
    void InvalidOutcomeLengthTest(final String value) {
        // when & then
        assertThatThrownBy(() -> new Outcome(value))
                .isInstanceOf(InvalidOutcomeLengthException.class);
    }
}
