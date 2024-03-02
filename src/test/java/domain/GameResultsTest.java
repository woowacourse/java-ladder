package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultsTest {

    @DisplayName("참가자의 이름으로 사다리 게임 결과를 조회한다.")
    @Test
    void findGameResultByName() {
        //given
        final GameResult gameResult1 = new GameResult("a", "1");
        final GameResult gameResult2 = new GameResult("b", "2");
        final GameResults gameResults = new GameResults(List.of(gameResult1, gameResult2));

        //when
        final GameResult gameResultFound = gameResults.findBy("a");

        //then
        assertThat(gameResultFound).isEqualTo(gameResult1);
    }
}
