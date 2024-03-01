package domain.game;

import domain.player.Player;
import domain.player.Players;
import domain.prize.Prize;
import domain.prize.Prizes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

class JudgeTest {
    private static final Player mang = new Player("mang");
    private static final Player roro = new Player("roro");
    private static final Player pobi = new Player("pobi");
    private static final Players players = new Players(List.of(mang, roro, pobi));
    private static final Prize prize1000 = new Prize("1000");
    private static final Prize prize500 = new Prize("500");
    private static final Prize prize30000 = new Prize("30000");
    private static final Prizes prizes = new Prizes(List.of(prize1000, prize500, prize30000));

    @Test
    @DisplayName("그대로인 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_is_same_as_initial() {
        PathMapper pathMapper = new PathMapper(List.of(0, 1, 2));
        Judge judge = new Judge(players, prizes, pathMapper);

        Map<Player, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
                    softly.assertThat(totalResult.get(mang)).isEqualTo(prize1000);
                    softly.assertThat(totalResult.get(roro)).isEqualTo(prize500);
                    softly.assertThat(totalResult.get(pobi)).isEqualTo(prize30000);
                }
        );
    }

    @Test
    @DisplayName("반대로 뒤집히는 경우에 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_sequence_reversed() {
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));
        Judge judge = new Judge(players, prizes, pathMapper);

        Map<Player, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
                    softly.assertThat(totalResult.get(mang)).isEqualTo(prize30000);
                    softly.assertThat(totalResult.get(roro)).isEqualTo(prize500);
                    softly.assertThat(totalResult.get(pobi)).isEqualTo(prize1000);
                }
        );
    }

    @Test
    @DisplayName("존재하지 않는 이름에 대한 상품을 요구하면 예외가 발생하는가")
    void throws_exception_when_require_prize_for_non_exist_name() {
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));

        Judge judge = new Judge(players, prizes, pathMapper);

        assertThatThrownBy(() -> judge.search("none"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("사용자를 찾을 수 없습니다.");
    }
}
