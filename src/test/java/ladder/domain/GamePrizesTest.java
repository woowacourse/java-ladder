package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamePrizesTest {

    @DisplayName("상품에 빈칸이 있는 경우 error를 발생한다.")
    @Test
    void hasBlankPrize() {

        List<String> gamePrizeInput = new ArrayList<>(List.of("꽝", " ", "5000", "꽝"));

        Assertions.assertThatThrownBy(() -> new GamePrizes(gamePrizeInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 목록엔 빈칸이 포함될 수 없습니다.");
    }
}
