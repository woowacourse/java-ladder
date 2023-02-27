package laddergame.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class GameResultTest {

    private List<Player> result;
    private WinningPrizes winningPrizes;
    private GameResult gameResult;

    @BeforeEach
    public void beforeEach() {
        //given
        result = List.of(new Player(new Name("준팍"), Position.of(0, 4)),
                new Player(new Name("에단"), Position.of(1, 4)),
                new Player(new Name("또링"), Position.of(2, 4)),
                new Player(new Name("코일"), Position.of(3, 4)));
        winningPrizes = WinningPrizes.of(List.of("1", "2", "3", "4"), 4);
        gameResult = new GameResult(result, winningPrizes);
    }

    @Test
    @DisplayName("player를 입력하면 해당되는 결과를 보여준다")
    void givenPlayerName_thenReturnResult() {
        //when
        final String playerResult = gameResult.findPlayerPrize("준팍");

        //then
        Assertions.assertThat(playerResult).isEqualTo(winningPrizes.getIndexPrize(0).getWinningPrize());
    }

}
