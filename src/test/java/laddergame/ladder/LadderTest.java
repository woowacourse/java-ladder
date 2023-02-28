package laddergame.ladder;

import laddergame.vo.Position;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class LadderTest {
    @Nested
    class 생성기능 {
        @Test
        void test_생성자_should_예외를던진다_when_Row의길이가일정하지않은경우() {
            // given
            List<Row> rows = List.of(
                    Row.of(List.of(Foothold.PASSABLE, Foothold.BLOCKED), 2),
                    Row.of(List.of(Foothold.BLOCKED), 1)
            );

            // when
            ThrowingCallable throwingCallable = () -> new Ladder(rows);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 길이가 균일하지 않습니다.");
        }

        @Test
        void test_생성자_should_정상생성_when_예외상황이아닌경우() {
            // given
            List<Row> rows = generateRowList();

            // when
            ThrowingCallable throwingCallable = () -> new Ladder(rows);

            //then
            assertThatNoException()
                    .isThrownBy(throwingCallable);
        }
    }

    @Nested
    class 플레이어이동기능 {
        @ParameterizedTest
        @CsvSource({"0,2", "1,0", "2,1", "3,3", "4,4"})
        void test_climbDownFrom_should_사다리를태우다_when_사용자현재위치가주어지면(int beforeMove, int expected) {
            // given
            Ladder ladder = new Ladder(generateRowList());
            Position initialPosition = new Position(beforeMove);

            // when
            Position destination = ladder.climbDownFrom(initialPosition);

            //then
            assertThat(destination).isEqualTo(new Position(expected));
        }
    }

    public static List<Row> generateRowList() {
        return List.of(
                Row.of(List.of(Foothold.PASSABLE, Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE), 4),
                Row.of(List.of(Foothold.BLOCKED, Foothold.PASSABLE, Foothold.BLOCKED, Foothold.PASSABLE), 4)
        );
    }
}
