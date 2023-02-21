package domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrizesTest {

    @Test
    @DisplayName("poition에 맞는 Prize를 반환하는 기능 테스튼")
    void getPrizeByPositionTest() {
        final int position = 0;
        final List<String> prizeNames = List.of("홍실", "다니");
        final Prizes prizes = new Prizes(prizeNames);

        Assertions.assertThat(prizes.getPrizeBy(position))
                .extracting("name")
                .isEqualTo(prizeNames.get(position));
    }
}
