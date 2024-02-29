package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResultsTest {

    static List<LadderResult> results() {
        return List.of(
                new LadderResult("맥북에어"),
                new LadderResult("맥북프로"),
                new LadderResult("에어팟맥스")
        );
    }

    static Players players() {
        return new Players(List.of(
                new Player("제우스"),
                new Player("명오"),
                new Player("호티")));
    }

    @DisplayName("사다리 결과의 개수가 인원수와 다르면 예외를 발생한다.")
    @Test
    void ladderResultsException() {
        List<LadderResult> ladderResultList = List.of(
                new LadderResult("맥북에어"),
                new LadderResult("맥북프로")
        );

        assertThatThrownBy(() -> new LadderResults(ladderResultList, players()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("인원수와 결과의 개수가 일치하지 않습니다");
    }

    @DisplayName("인덱스를 입력하면 결과를 반환한다.")
    @Test
    void climbFrom() {
        LadderResults results = new LadderResults(results(), players());
        assertThat(results.get(0))
                .isEqualTo(new LadderResult("맥북에어"));
    }

    @DisplayName("잘못된 인덱스를 입력하면 예외를 발생한다.")
    @Test
    void climbFromException() {
        LadderResults results = new LadderResults(results(), players());
        assertThatThrownBy(() -> results.get(- 1))
                .isInstanceOf(IllegalStateException.class);
    }
}
