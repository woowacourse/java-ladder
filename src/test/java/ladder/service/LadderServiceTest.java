package ladder.service;

import static org.assertj.core.api.Assertions.assertThat;

import ladder.domain.Players;
import ladder.util.RandomLineStrategy;
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
    void create_usingComma() {
        // given
        String input = "glen,doggy";

        // when
        Players players = ladderService.createPlayers(input);

        // then
        assertThat(players.getPlayers()).hasSize(2);
    }
}
