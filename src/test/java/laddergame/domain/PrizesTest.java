package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PrizesTest {

    List<String> playerNames = List.of("pobi","honux","crong","jk");
    Players players = new Players(playerNames);

    @Test
    @DisplayName("Prizes가 정상적으로 생성된다.")
    void prizesCreateTest() {
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        assertDoesNotThrow(() -> new Prizes(prizes, players.size()));
    }

    @Nested
    @DisplayName("사다리 상품의 개수가 플레이어의 수와 동일한지 테스트")
    class PrizesCountTest {

        @Test
        @DisplayName("사다리 삼품의 개수가 플레이어의 수와 동일하면 사다리 결과가 정상적으로 생성된다.")
        public void PrizesCountIsSameTest () {
            List<String> results = List.of("꽝", "5000", "꽝", "3000");
            Prizes prize = new Prizes(results, players.size());

            assertThat(prize.size()).isEqualTo(players.size());
        }

        @Test
        @DisplayName("사다리 상품의 개수가 플레이어의 수와 동일하지 않으면 예외가 발생한다.")
        public void PrizesCountIsDiffTest () {
            List<String> results = List.of("꽝", "5000", "꽝");

            assertThatThrownBy(() -> new Prizes(results, players.size()))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}
