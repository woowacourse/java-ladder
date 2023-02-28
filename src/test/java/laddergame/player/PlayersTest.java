package laddergame.player;

import laddergame.ladder.Ladder;
import laddergame.ladder.LadderTest;
import laddergame.vo.Position;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class PlayersTest {
    @Nested
    class 생성기능 {
        @Test
        void test_from_should_예외를던진다_when_플레이어가1명이하인경우() {
            // given
            List<String> playerNames = List.of("에밀");

            // when
            ThrowingCallable throwingCallable = () -> Players.from(playerNames);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("플레이어는 2명 이상이어야 합니다.");
        }

        @Test
        void test_from_should_예외를던진다_when_플레이어이름이중복인경우() {
            // given
            List<String> playerNames = List.of("에밀", "에밀");

            // when
            ThrowingCallable throwingCallable = () -> Players.from(playerNames);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("이름에 중복이 존재합니다");
        }

        @Test
        void test_from_should_정상생성_when_예외상황이아닌경우() {
            // given
            List<String> playerNames = List.of("에밀", "홍고");

            // when
            ThrowingCallable throwingCallable = () -> Players.from(playerNames);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }

    @Nested
    class 사다리타는기능 {
        @Test
        void test_climbDownLadder_should_플레이어와위치를반환_when_사다리가주어졌을때() {
            // given
            Player p1 = new Player("첫째", 0);
            Player p2 = new Player("둘째", 1);
            Player p3 = new Player("셋째", 2);
            Player p4 = new Player("넷째", 3);
            Player p5 = new Player("다섯째", 4);
            Players players = new Players(List.of(p1, p2, p3, p4, p5));
            Ladder ladder = new Ladder(LadderTest.generateRowList());
            Map<Player, Position> expected = new HashMap<>(Map.of(
                    p1, new Position(2),
                    p2, new Position(0),
                    p3, new Position(1),
                    p4, new Position(3),
                    p5, new Position(4)
            ));

            // when
            Map<Player, Position> gameResult = players.climbDownLadder(ladder);

            //then
            assertThat(gameResult).isEqualTo(expected);
        }
    }
}
