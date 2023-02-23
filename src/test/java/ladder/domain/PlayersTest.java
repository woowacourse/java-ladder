package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayersTest {
    @Test
    @DisplayName("플레이어가 1명 이하면 예외 던지기")
    public void size_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("플레이어는 2명 이상이어야 합니다.");
    }

    @Test
    @DisplayName("플레이어 이름이 중복이면 예외 던지기")
    public void 이름_중복_예외던지기() {
        assertThatThrownBy(() -> Players.from(List.of("에밀", "에밀")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름에 중복이 존재합니다");
    }

    @Test
    @DisplayName("플레이어수를 반환한다")
    public void getPlayerSize() {
        assertThat(Players.from(List.of("에밀", "홍고"))
                          .getCount())
                .isEqualTo(2);
    }

    @Test
    void should_플레이어와위치를반환_when_사다리가주어졌을때() {
        // given
        Players players = Players.from(List.of("첫째", "둘째", "셋째", "넷째", "다섯째"));
        Ladder ladder = new Ladder(LadderTest.generateRowList());
//        Prizes prizes = Prizes.from(List.of(
//                "0",
//                "1",
//                "2",
//                "3",
//                "4"
//        ));
        Map<Player, Position> expected = new HashMap<>(Map.of(
                players.get(0), new Position(2),
                players.get(1), new Position(0),
                players.get(2), new Position(1),
                players.get(3), new Position(3),
                players.get(4), new Position(4)
        ));

        // when
        Map<Player, Position> gameResult = players.climbDownLadder(ladder);

        //then
        assertThat(gameResult).isEqualTo(expected);
    }
}
