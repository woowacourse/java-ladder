package domain.ladder;


import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    @DisplayName("입력받은 크기와 LadderResults의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_success_by_same_size() {
        // given
        List<LadderResult> ladderResults = List.of(new LadderResult("any"), new LadderResult("any"));

        // then
        assertThatNoException().isThrownBy(
                () -> LadderResults.createWithSameSize(ladderResults, ladderResults.size()));
    }

    @DisplayName("입력받은 크기와 LadderResults의 크기가 다르면 생성시 예외를 반환한다.")
    @Test
    void create_fail_by_different_size() {
        // given
        List<LadderResult> ladderResults = List.of(new LadderResult("any"), new LadderResult("any"));

        // then
        assertThatThrownBy(() -> LadderResults.createWithSameSize(ladderResults, ladderResults.size() - 1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("크기가 일치하지 않습니다.");
    }
}
