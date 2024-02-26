package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("사다리 결과들 일급 컬렉션 테스트")
class LadderResultsTest {

    @DisplayName("결과의 개수를 반환할 수 있다")
    @Test
    void testCountResults() {
        List<LadderResult> ladderResults = List.of(new LadderResult("123"), new LadderResult("123"),
                new LadderResult("123"));
        assertThat(new LadderResults(ladderResults).getResultCount()).isEqualTo(3);
    }
}
