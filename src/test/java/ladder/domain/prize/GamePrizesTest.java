package ladder.domain.prize;

import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GamePrizesTest {

    private static final int MAXIMUM_PRIZE_LENGTH = 5;

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

    @DisplayName("최대 입력 글자 개수를 넘었을 경우 Error를 던지는지 Prize Test")
    @Test
    void isOverMaximumTest() {
        List<String> gamePrizeInput = new ArrayList<>(List.of("꽝", "500000000", "꽝"));

        Assertions.assertThatThrownBy(() -> new GamePrizes(gamePrizeInput, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("최대 글자 개수는 " + MAXIMUM_PRIZE_LENGTH + "개 입니다.");
    }
}
