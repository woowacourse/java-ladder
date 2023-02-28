package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameResultTest {

    private Players players;
    private WinningPrizes winningPrizes;
    private GameResult gameResult;

    @BeforeEach
    public void beforeEach() {
        //given
        players = Players.from(List.of("준팍", "에단", "또링", "코일"));
        winningPrizes = WinningPrizes.of(List.of("1", "2", "3", "4"), 4);
        gameResult = new GameResult(players, winningPrizes);
    }

    @Test
    @DisplayName("player를 입력하면 해당되는 결과를 보여준다")
    void givenPlayerName_thenReturnResult() {
        //when
        final String playerResult = gameResult.findPlayerPrize("준팍");

        //then
        assertThat(playerResult).isEqualTo(winningPrizes.getIndexPrize(0).getWinningPrize());
    }

    @Nested
    class IsContainTest {
        @ParameterizedTest
        @DisplayName("참여한 플레이어의 이름을 입력하면 true를 반환한다.")
        @ValueSource(strings = {"준팍", "에단", "또링", "코일"})
        void givenPlayerName_thenTrue(String command) {
            //when
            final boolean contain = gameResult.isContain(command);

            //then
            assertThat(contain).isTrue();
        }

        @Test
        @DisplayName("참여하지 않은 플레이어의 이름을 입력하면 false를 반환한다.")
        void givenPlayerName_thenTrue() {
            //when
            final boolean contain = gameResult.isContain("박준현");

            //then
            assertThat(contain).isFalse();
        }
    }
}
