package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGameResultTest {
    @Test
    @DisplayName("이름 개수와 사다리 결과 개수가 같지 않으면 예외 발생")
    void validateLadderResultNamesLength() {
        Names names = new Names(List.of(new Name("name1"), new Name("name2")));
        LadderResults ladderResults = new LadderResults(
                List.of(new LadderResult("상품1"), new LadderResult("상품2"), new LadderResult("꽝")));

        Assertions.assertThatThrownBy(() -> new LadderGameResult(names, ladderResults))
                .isInstanceOf(LadderGameException.class)
                .hasMessage(ExceptionType.NOT_ALLOW_DIFFERENT_NAMES_LADDER_RESULTS_LENGTH.getMessage());
    }

}