package ladder.domain.player;

import ladder.domain.exception.PlayerNumberException;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class PlayersTest {

    @Test
    void Players_생성_테스트() {
        assertThatCode(() -> new Players(List.of("pobi", "crong")))
                .doesNotThrowAnyException();
    }

    @Test
    void 총_플레이어는_두명_이상이_아니면_예외_발생() {
        assertThatThrownBy(() -> new Players(List.of("pobi")))
                .isInstanceOf(PlayerNumberException.class);
    }

    @Test
    void 플레이어_별_게임_결과가_잘_저장되는지_테스트() {
        Players players = new Players(List.of("1", "2", "3"));
        players.recordGameResult(List.of("1result", "2result", "3result"));

        Map<Player, String> ladderGameResult = players.getAllGameRecords();

        ladderGameResult.forEach((k, v) -> assertThat(k.getName() + "result").isEqualTo(v));
    }
}
