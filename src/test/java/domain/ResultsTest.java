package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    @DisplayName("참여자 수 만큼 입력되지 않으면 예외 처리")
    void validateSize() {
        assertThatThrownBy(() -> new Results(3, List.of("꽝", "꽝")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Results.SIZE_ERROR);
    }

    @Test
    @DisplayName("targetPlayer에 all이 입력되면 참여자 결과 모두 반환")
    void getAllFinalResults() {
        Results results = new Results(3, List.of("꽝", "5000", "3000"));

        assertThat(results.getFinalResults(List.of("a", "b", "c"), List.of(1, 0, 2), "all"))
                .isEqualTo(new Results(3, List.of("5000", "꽝", "3000")));
    }

    @Test
    @DisplayName("targetPlayer에 참여자 이름이 입력되면 해당 참여자 결과만 반환")
    void getSingleFinalResults() {
        Results results = new Results(3, List.of("꽝", "5000", "3000"));

        assertThat(results.getFinalResults(List.of("a", "b", "c"), List.of(1, 0, 2), "a"))
                .isEqualTo(new Results(1, List.of("5000")));
    }
}