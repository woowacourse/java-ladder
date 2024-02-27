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
}
