package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LadderGameTest {

    private List<String> names;
    private Players players;
    private LadderGame ladderGame;

    @BeforeEach
    public void beforeEach() {

        //given
        names = List.of("준팍", "에단", "또링", "코일");
        players = Players.from(names);
        final Ladder ladder = new Ladder(new Height(1), names.size());
        final List<String> prizes = List.of("꽝", "당첨", "꽝", "다음 기회에");
        final WinningPrizes winningPrizes = WinningPrizes.of(prizes, names.size());

        ladderGame = new LadderGame(players, ladder, winningPrizes);
    }

    @Test
    @DisplayName("Layer와 Players를 입력하면 해당 층의 결과를 반환한다.")
    void givenLayerAndPlayers_thenReturnLayerResult() {

        //when
        final Layer layer = Layer.of(names.size(), new TestLinkGenerator(List.of(true, false, true)));
        final List<Player> testPlayers = players.getPlayers();

        ladderGame.evaluateLayerResult(testPlayers, layer);
        final List<Player> playerResult = Players.from(List.of("에단", "준팍", "코일", "또링")).getPlayers();


        //then
        assertThat(testPlayers)
                .isEqualTo(playerResult);
    }


}
