package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizeResultsTest {
    @Test
    @DisplayName("Players, Prizes를 통해 생성한다.")
    void createSuccess() {
        assertThatCode(() -> PrizeResults.of(
                        new Players(List.of("wiib", "pobi", "haha")),
                        new Prizes(List.of("꽝", "당첨", "꽝"))
                )
        ).isInstanceOf(PrizeResults.class)
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Players, Prizes의 Size가 다르면 예외를 발생한다.")
    void createFailRange() {
        assertThatCode(() -> PrizeResults.of(
                new Players(List.of("wiib", "pobi", "haha")),
                new Prizes(List.of("꽝", "당첨", "꽝", "당첨"))
        )).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format("실행 결과는 참여자와 같은 갯수를 입력해주세요. 입력 : %d개", 4));
    }
}
