package domain.ladder;

import domain.generator.RandomBooleanGenerator;
import domain.player.Players;
import domain.result.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class LadderGameTest {

    @Test
    @DisplayName("참가자, 결과, 사다리를 멤버로 가지는 사다리 게임 객체가 생성된다.")
    void createLadderGameSuccess() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());

        LadderGame ladderGame = LadderGame.of(players, prizes, ladder);

        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("참가자 수와, 실행 결과 수가 다르면 예외가 발생한다.")
    void createLadderGameFail() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝", "100000원"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());

        assertThatThrownBy(() -> LadderGame.of(players, prizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수와 결과 수는 일치해야 합니다.");
    }

    @Test
    @DisplayName("결과를 조회하는 이름이 참가자 목록에 존재하면, 해당 참가자의 결과를 반환한다")
    void searchResultByNameSuccess() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());
        String resultName = "grey";

        LadderGame ladderGame = LadderGame.of(players, prizes, ladder);
        String prize = ladderGame.findByName(resultName);

        assertThat(prizes.getPrizes().contains(prize)).isTrue();
    }

    @Test
    @DisplayName("결과를 조회하는 이름이 참가자 목록에 존재하지 않으면 예외가 발생한다")
    void searchResultByNameFail() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());
        String resultName = "hello";

        LadderGame ladderGame = LadderGame.of(players, prizes, ladder);

        assertThatThrownBy(() -> ladderGame.findByName(resultName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("이름과 일치하는 참가자가 존재하지 않습니다.");
    }
}
