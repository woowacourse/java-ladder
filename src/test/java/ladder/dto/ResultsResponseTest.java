package ladder.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Prize;
import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResultsResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void ofResults_success() {
        // given
        Prizes prizes = new Prizes(createResults(), 4);

        // when
        PrizesResponse prizesResponse = PrizesResponse.ofResults(prizes);

        // then
        assertThat(prizesResponse.getPrizes())
                .isEqualTo("꽝     5000  꽝     3000 ");
    }

    private static List<Prize> createResults() {
        return List.of(
                new Prize("꽝"),
                new Prize("5000"),
                new Prize("꽝"),
                new Prize("3000"));
    }
}
