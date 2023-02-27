package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {

    private List<String> names;
    private Players players;
    private Ladder ladder;
    private WinningPrizes winningPrizes;
    private LadderGame ladderGame;

    @BeforeEach
    public void beforeEach() {

        //given
        names = List.of("준팍", "에단", "또링", "코일");
        players = Players.from(names);
        ladder = Ladder.of(new Height(3), names.size(), new TestLinkGenerator(
                List.of(true, false, true, false, true, false, true, false, true)));
        winningPrizes = WinningPrizes.of(List.of("1", "2", "3", "4"), names.size());
        ladderGame = new LadderGame(players, ladder, winningPrizes);
    }

    @Test
    @DisplayName("Layer와 Players를 입력하면 게임의 결과를 반환한다.")
    void givenLayerAndPlayers_thenReturnGameResult() {

        //when
        final GameResult gameResult = ladderGame.playGame();

        //then
        assertThat(gameResult.getGameResult())
                .isEqualTo(Players.from(List.of("코일", "에단", "또링", "준팍")).getPlayers());
    }

}
