package ladder.domain;

import ladder.domain.ladder.NoncontinuousRandomLineStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {
    @Test
    @DisplayName("이름과 실행 결과의 개수가 같지 않은 경우 예외를 던진다.")
    void ladderGame_throwException_NotSameNameAndResultCount() {
        // given
        List<String> names = new ArrayList<>(List.of("vero", "poi", "glen"));
        List<String> results = new ArrayList<>(List.of("꽝", "당첨"));

        // expected
        assertThatThrownBy(() -> new LadderGame(names, results, 4, new NoncontinuousRandomLineStrategy()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
