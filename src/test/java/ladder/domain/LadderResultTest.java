package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("사다리 결과")
public class LadderResultTest {
    @DisplayName("존재하지 않는 사람의 결과를 구하려고 하면 예외를 발생시킨다.")
    @Test
    void nonexistencePersonNameTest() {
        // given
        LadderResult ladderResult = new LadderResult(Map.of(
                "pobi", "1등",
                "neo", "2등"));

        // when & then
        assertThatThrownBy(() -> ladderResult.findWinningItemNameByPersonName("nak"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("존재하지 않는 사람의 이름입니다.");
    }
}
