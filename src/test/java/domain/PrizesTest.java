package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestLineItemGenerator;
import view.LineItem;
import java.util.List;

class PrizesTest {

    @DisplayName("실행 결과 개수가 참여자 수와 다른 경우 예외가 발생한다.")
    @Test
    void occurExceptionIfPrizesIsInvalidLength() {
        // given
        int playerCount = 3;

        // when & then
        assertThatThrownBy(() -> new Prizes(List.of("꽝", "2000", "3000", "꽝"), playerCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Prizes.ERROR_IS_INVALID_LENGTH);
    }

    @DisplayName("현재 위치의 사다리 실행 결과를 반환한다.")
    @Test
    void returnPrizeByCurrentPosition() {
        // given
        int playerCount = 4;
        int position = 0;
        TestLineItemGenerator lineItemGenerator = new TestLineItemGenerator(LineItem.CONNECTED);
        Ladder ladder = Ladder.of(new Height("5"), playerCount, lineItemGenerator);
        ladder.playLadderGame(position);
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), playerCount);

        // when
        Prize result = prizes.findPrizeByPosition(position);

        // then
        assertThat(result.getPrize()).isEqualTo(prizes.findPrizeByPosition(2).getPrize());
    }
}
