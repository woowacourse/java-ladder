package laddergame.ladder;

import laddergame.vo.Position;
import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RowTest {
    @Nested
    class 생성기능 {
        @Test
        void test_of_should_예외를던진다_when_연속발판이존재하는경우() {
            // given
            List<Foothold> continuousFootholds = List.of(Foothold.PASSABLE, Foothold.PASSABLE);
            int footholdsLength = 2;

            // when
            ThrowingCallable throwingCallable = () -> Row.of(continuousFootholds, footholdsLength);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("가로로 연속된 발판은 만들 수 없습니다.");
        }

        @Test
        void test_of_should_예외를던진다_when_실제발판길이와기대한길이가다른경우() {
            // given
            List<Foothold> footholds = List.of(Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE);
            int expectedWidth = 2;

            // when
            ThrowingCallable throwingCallable = () -> Row.of(footholds, expectedWidth);

            //then
            assertThatThrownBy(throwingCallable)
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("사다리 너비가 맞지 않습니다.");
        }

        @Test
        void test_of_should_Row정상생성_when_예외상황이아닌경우() {
            // given
            List<List<Foothold>> footholdsList = List.of(
                    List.of(Foothold.PASSABLE, Foothold.BLOCKED),
                    List.of(Foothold.BLOCKED, Foothold.BLOCKED),
                    List.of(Foothold.PASSABLE),
                    List.of(Foothold.BLOCKED),
                    List.of()
            );


            for (var footholds : footholdsList) {
                // when
                ThrowingCallable throwingCallable = () -> Row.of(footholds, footholds.size());

                //then
                assertThatNoException()
                        .isThrownBy(throwingCallable);
            }
        }
    }

    @Nested
    class 플레이어이동기능 {
        @ParameterizedTest
        @CsvSource({"0,1", "1,0", "2,2", "3,4", "4,3"})
        void test_movePlayer_should_이동후결과위치를반환한다_when_현재사용자위치를입력하면(int current, int afterMove) {
            // given
            List<Foothold> footholds = List.of(Foothold.PASSABLE, Foothold.BLOCKED, Foothold.BLOCKED, Foothold.PASSABLE);
            Row row = Row.of(footholds, footholds.size());
            Position currentPosition = new Position(current);
            Position expected = new Position(afterMove);

            // when
            Position actual = row.movePlayer(currentPosition);


            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
