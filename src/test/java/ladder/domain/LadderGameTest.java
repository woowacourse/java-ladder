package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Rung;
import ladder.domain.player.Players;
import ladder.domain.prize.Prize;
import ladder.domain.prize.Prizes;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LadderGameTest {
    @ParameterizedTest
    @CsvSource(value = {"a,2", "b,1", "c,3"}, delimiter = ',')
    @DisplayName("참가자와 상품을 매칭한다.")
    void matchPlayersAndPrizes(String playerName, String prize) {
        Players players = Players.from(List.of("a", "b", "c"));
        Prizes prizes = Prizes.of(List.of("1", "2", "3"), players.size());

        int height = 1;
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY);
        Ladder ladder = Ladder.of(height, players.size(), new MockRungGenerator(rungs));

        LadderGame ladderGame = LadderGame.of(players, ladder, prizes);

        assertThat(ladderGame.getResultByPlayerName(playerName)).isEqualTo(new Prize(prize));
    }

    @Test
    @DisplayName("존재하지 않는 참가자일 경우 예외를 발생한다.")
    void getResultByPlayerName() {
        Players players = Players.from(List.of("a", "b"));
        Prizes prizes = Prizes.of(List.of("1", "2"), players.size());

        int height = 1;
        List<Rung> rungs = List.of(Rung.EXIST);
        Ladder ladder = Ladder.of(height, players.size(), new MockRungGenerator(rungs));

        LadderGame ladderGame = LadderGame.of(players, ladder, prizes);

        assertThatThrownBy(() -> ladderGame.getResultByPlayerName("c"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
