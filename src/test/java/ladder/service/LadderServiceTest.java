package ladder.service;

import static ladder.Util.createPlayers;
import static ladder.Util.createPrizes;
import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import ladder.domain.Prizes;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderServiceTest {

    LadderService ladderService;

    @BeforeEach
    void setUp() {
        ladderService = new LadderService(new RandomLineStrategy());
    }

    @Test
    @DisplayName("사용자 이름이 입력되면 콤마(,) 로 구분한다.")
    void createPlayers_usingComma() {
        // given
        String input = "glen,doggy";

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
        Height height = new Height(5);

        // when
        Ladder ladder = ladderService.createLadder(height, createPlayers(5));

        // then
        assertThat(ladder.getLines().size())
                .isEqualTo(5);
    }

    @Test
    @DisplayName("실행 결과가 입력되면 콤마(,) 로 구분한다.")
    void createResults_usingComma() {
        // given
        String input = "꽝,5000,꽝,3000";

        // when
        Prizes prizes = ladderService.createPrizes(input, createPlayers(4));

        // then
        assertThat(prizes.getPrizes())
                .isEqualTo(createPrizes("꽝", "5000", "꽝", "3000"));
    }
}
