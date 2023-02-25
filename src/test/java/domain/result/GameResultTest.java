package domain.result;

import domain.generator.RandomBooleanGenerator;
import domain.ladder.Ladder;
import domain.ladder.LadderGame;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultTest {

    @Test
    @DisplayName("결과를 조회하는 이름이 참가자 목록에 존재하면, 해당 참가자의 결과를 반환한다")
    void searchResultByNameSuccess() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());
        String resultName = "grey";

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        GameResult gameResult = ladderGame.start();
        String prize = gameResult.findByName(resultName);

        assertThat(prizes.getPrizes().contains(prize)).isTrue();
    }

    @Test
    @DisplayName("결과를 조회하는 이름이 참가자 목록에 존재하지 않으면 예외가 발생한다")
    void searchResultByNameFail() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());
        String resultName = "hello";

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);
        GameResult gameResult = ladderGame.start();

        assertThatThrownBy(() -> gameResult.findByName(resultName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름과 일치하는 참가자가 존재하지 않습니다.");
    }

}
