package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.prize.GamePrizes;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamePrizesTest {

    @DisplayName("상품에 빈칸이 있는 경우 error를 발생한다.")
    @Test
    void hasBlankPrize() {

        List<String> gamePrizeInput = new ArrayList<>(List.of("꽝", " ", "5000", "꽝"));

        Assertions.assertThatThrownBy(() -> new GamePrizes(gamePrizeInput, 4))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("상품 목록엔 빈칸이 포함될 수 없습니다.");
    }

    @DisplayName("참가한 유저와 일치하는 개수의 Prize를 입력하지 않았을 경우 Test")
    @Test
    void isCorrespondentToParticipantCount() {

        List<String> gamePrizeInput = new ArrayList<>(List.of("꽝", "0", "5000", "꽝"));

        Assertions.assertThatThrownBy(() -> new GamePrizes(gamePrizeInput, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("참가자와 상품의 개수가 일치하지 않습니다.");
    }
}
