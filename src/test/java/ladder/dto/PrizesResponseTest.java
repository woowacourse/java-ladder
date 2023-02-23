package ladder.dto;

import static ladder.Util.createPlayers;
import static ladder.Util.createPrizes;
import static org.assertj.core.api.Assertions.*;

import ladder.domain.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void ofResults_success() {
        // given
        Prizes prizes = new Prizes(createPrizes("꽝", "5000", "꽝", "3000"), createPlayers(4));

        // when
        PrizesResponse prizesResponse = PrizesResponse.ofPrizes(prizes);

        // then
        assertThat(prizesResponse.getPrizes())
                .isEqualTo("꽝     5000  꽝     3000 ");
    }
}
