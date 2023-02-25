package domain.ladder;

import domain.generator.RandomBooleanGenerator;
import domain.player.Players;
import domain.result.GameResult;
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

        LadderGame ladderGame = new LadderGame(players, prizes, ladder);

        assertThat(ladderGame).isNotNull();
    }

    @Test
    @DisplayName("참가자 수와, 실행 결과 수가 다르면 예외가 발생한다.")
    void createLadderGameFail() {
        Players players = new Players(List.of("grey", "pobi", "brown"));
        Prizes prizes = new Prizes(List.of("10000원", "20000원", "꽝", "100000원"));
        Ladder ladder = new Ladder(players.getPlayers().size(), 5, new RandomBooleanGenerator());

        assertThatThrownBy(() -> new LadderGame(players, prizes, ladder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("참가자 수와 결과 수는 일치해야 합니다.");
    }
}
