package laddergame.domain.prize;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrizeTest {

    @Test
    @DisplayName("결과가 String으로 주어지면 Prize객체가 반환돤다.")
    void givenResultStringName_thenReturnPrize() {
        // given
        final String prizeName = "꽝";

        // when
        final Prize prize = new Prize(prizeName);

        // then
        assertThat(prize)
                .extracting("prize")
                .isEqualTo(prizeName);
    }
}
