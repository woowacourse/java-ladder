package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @DisplayName("사다리 결과의 개수가 인원수와 다르면 예외를 발생한다.")
    @Test
    void ladderResultsException() {
        Players players = new Players(List.of("제우스", "명오", "호티"));
        List<LadderResult> ladderResultList = List.of(
                new LadderResult("맥북에어"),
                new LadderResult("맥북프로")
        );

        assertThatThrownBy(() -> new LadderResults(ladderResultList, players))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("인원수와 결과의 개수가 일치하지 않습니다");
    }
}
