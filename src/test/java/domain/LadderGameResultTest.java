package domain;

import java.util.List;
import java.util.Map;
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


    @Test
    @DisplayName("참여자 이름에 대응하는 사다리 결과 결과 반환")
    void testGetLadderResult() {
        Names names = new Names(List.of(new Name("name1"), new Name("name2")));
        LadderResults ladderResults = new LadderResults(
                List.of(new LadderResult("상품1"), new LadderResult("상품2")));

        names.swapNamePosition(1);
        LadderGameResult ladderGameResult = new LadderGameResult(names, ladderResults);

        Map<Name, LadderResult> result = ladderGameResult.getLadderGameResult();
        LadderResult actual = result.get(names.getNames().get(0));
        LadderResult expected = ladderResults.getLadderResults().get(1);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}