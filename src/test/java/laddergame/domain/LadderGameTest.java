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
        ladderGame = new LadderGame();
    }

    @Test
    @DisplayName("Layer와 Players를 입력하면 게임의 결과를 반환한다.")
    void givenLayerAndPlayers_thenReturnGameResult() {

        //when
        final List<Layer> layers = List.of(
                Layer.of(names.size(), new TestLinkGenerator(List.of(true, false, true))),
                Layer.of(names.size(), new TestLinkGenerator(List.of(false, true, false))),
                Layer.of(names.size(), new TestLinkGenerator(List.of(true, false, true))));


        final List<Player> gameResult = ladderGame.playGame(players.getPlayers(), layers);

        final List<Player> playerResult = Players.from(List.of("코일", "에단", "또링", "준팍")).getPlayers();


        //then
        assertThat(gameResult)
                .isEqualTo(playerResult);
    }

}
