package ladder.service;

import static ladder.Util.createPlayers;
import static ladder.Util.createPrizes;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.PlayerResults;
import ladder.domain.Players;
import ladder.domain.Prizes;
import ladder.domain.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderServiceTest {

    LadderService ladderService;

    @BeforeEach
    void setUp() {
        ladderService = new LadderService(new CustomLineStrategy(List.of(Step.EMPTY)));
    }

    @Test
    @DisplayName("사용자 이름이 입력되면 콤마(,) 로 구분한다.")
    void createPlayers_usingComma() {
        // given
        String[] input = {"glen", "doggy"};

        // when
        Players players = ladderService.createPlayers(input);

        // then
        assertThat(players.getPlayers())
                .hasSize(2);
    }

    @Test
    @DisplayName("사다리가 정상적으로 생성되어야 한다.")
    void createLadder_success() {
        // given
        Players players = createPlayers(13);
        Height height = new Height(26, players);
        ladderService = new LadderService(new RandomLineStrategy());

        // when
        Ladder ladder = ladderService.createLadder(height, players);

        // then
        assertThat(ladder.getLines())
                .hasSize(26);
    }

    @Test
    @DisplayName("실행 결과가 입력되면 콤마(,) 로 구분한다.")
    void createResults_usingComma() {
        // given
        String[] input = {"꽝", "5000", "꽝", "3000"};

        // when
        Prizes prizes = ladderService.createPrizes(input, createPlayers(4));

        // then
        assertThat(prizes.getPrizes())
                .isEqualTo(createPrizes("꽝", "5000", "꽝", "3000"));
    }

    @Test
    @DisplayName("게임의 결과가 정확히 반환되어야 한다.")
    void createPlayerResults_success() {
        // given
        Players players = createPlayers("glen", "pobi", "bero");
        Height height = new Height(5, players);
        Ladder ladder = ladderService.createLadder(height, players);
        Prizes prizes = new Prizes(createPrizes("1000", "꽝", "5000"), players);

        // when
        PlayerResults playerResults = ladderService.createPlayerResults(players, ladder, prizes);

        // then
        assertThat(playerResults.getPlayerResults())
                .hasSize(3);
        assertThat(playerResults.findByPlayerName("glen").getPrize())
                .isEqualTo("1000");
        assertThat(playerResults.findByPlayerName("pobi").getPrize())
                .isEqualTo("꽝");
        assertThat(playerResults.findByPlayerName("bero").getPrize())
                .isEqualTo("5000");
    }
}
