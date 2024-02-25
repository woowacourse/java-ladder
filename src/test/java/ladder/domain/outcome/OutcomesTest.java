package ladder.domain.outcome;

import ladder.exception.outcome.MismatchedOutcomesCountException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OutcomesTest {
    @Test
    @DisplayName("실행 결과의 개수가 요청된 개수와 다르면 예외가 발생한다.")
    void invalidOutcomesCountTest() {
        // given
        final int neededOutcomesCount = 3;
        final List<String> outcomes = List.of("1", "꽝");

        // when & then
        assertThatThrownBy(() -> new Outcomes(outcomes, neededOutcomesCount))
                .isInstanceOf(MismatchedOutcomesCountException.class);
    }
}
