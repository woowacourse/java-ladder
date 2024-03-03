package domain.result;

import domain.exception.ExceptionType;
import domain.exception.LadderGameException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsCreatorTest {
    @Test
    @DisplayName("콤마가 앞에 있거나 뒤에 있으면 예외를 발생시킨다")
    void validateSeparator() {
        LadderResultsCreator ladderResultsCreator = new LadderResultsCreator();
        Assertions.assertThatThrownBy(() -> ladderResultsCreator.create(",in,valid,"))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.INVALID_SEPARATOR_POSITION.getMessage());
    }

    @Test
    @DisplayName("사다리 결과는 콤마로 구분된다.")
    void testCreateLadderResults() {
        LadderResultsCreator ladderResultsCreator = new LadderResultsCreator();
        LadderResults ladderResults = ladderResultsCreator.create("a,b,c,d,e");

        int actual = ladderResults.getLadderResults().size();
        int expected = 5;

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}