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
    private static final Player MANG = new Player("mang");
    private static final Player RORO = new Player("roro");
    private static final Player POBI = new Player("pobi");
    private static final Players PLAYERS = new Players(List.of(MANG, RORO, POBI));
    private static final Prize PRIZE_1000 = new Prize("1000");
    private static final Prize PRIZE_500 = new Prize("500");
    private static final Prize PRIZE_30000 = new Prize("30000");
    private static final Prizes PRIZES = new Prizes(List.of(PRIZE_1000, PRIZE_500, PRIZE_30000));

    @Test
    @DisplayName("단일 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_for_single_player() {
        PathMapper pathMapper = new PathMapper(List.of(1, 0, 2));
        Judge judge = new Judge(PLAYERS, PRIZES, pathMapper);

        assertSoftly(softly -> {
            softly.assertThat(judge.search("mang").get(MANG)).isEqualTo(PRIZE_500);
            softly.assertThat(judge.search("roro").get(RORO)).isEqualTo(PRIZE_1000);
            softly.assertThat(judge.search("pobi").get(POBI)).isEqualTo(PRIZE_30000);
        });
    }

    @Test
    @DisplayName("시작점과 도착점이 동일한 경우, 참가자들의 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_arrival_is_same_as_initial() {
        PathMapper pathMapper = new PathMapper(List.of(0, 1, 2));
        Judge judge = new Judge(PLAYERS, PRIZES, pathMapper);

        Map<Player, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
            softly.assertThat(totalResult.get(MANG)).isEqualTo(PRIZE_1000);
            softly.assertThat(totalResult.get(RORO)).isEqualTo(PRIZE_500);
            softly.assertThat(totalResult.get(POBI)).isEqualTo(PRIZE_30000);
        });
    }

    @Test
    @DisplayName("시작점과 도착점이 반대로 뒤집히는 경우, 참가자에 대한 상품이 정상적으로 반환되는가")
    void does_prize_return_correctly_when_departure_and_arrival_reversed() {
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));
        Judge judge = new Judge(PLAYERS, PRIZES, pathMapper);

        Map<Player, Prize> totalResult = judge.search("all");

        assertSoftly(softly -> {
            softly.assertThat(totalResult.get(MANG)).isEqualTo(PRIZE_30000);
            softly.assertThat(totalResult.get(RORO)).isEqualTo(PRIZE_500);
            softly.assertThat(totalResult.get(POBI)).isEqualTo(PRIZE_1000);
        });
    }

    @Test
    @DisplayName("존재하지 않는 이름에 대한 상품을 요구하면 예외가 발생하는가")
    void throws_exception_when_require_prize_for_non_exist_name() {
        PathMapper pathMapper = new PathMapper(List.of(2, 1, 0));

        Judge judge = new Judge(PLAYERS, PRIZES, pathMapper);

        assertThatThrownBy(() -> judge.search("none"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
