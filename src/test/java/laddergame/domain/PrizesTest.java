package laddergame.domain;

import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PrizesTest {
    
    @Test
    @DisplayName("결과들이 List<String>으로 주어지면 Prizes가 반환된다.")
    void givenListString_thenReturnPrizes() {
        // given
        final List<String> resultNames = List.of("꽝", "1000", "5000", "10000");

        // when
        final Prizes prizes = new Prizes(resultNames, resultNames.size());

        // then
        assertThat(prizes)
                .extracting("prizes")
                .asInstanceOf(InstanceOfAssertFactories.list(Prize.class))
                .extracting("prize")
                .isEqualTo(resultNames);
    }

}
