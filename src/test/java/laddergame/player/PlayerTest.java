package laddergame.player;

import laddergame.ladder.Ladder;
import laddergame.ladder.LadderTest;
import laddergame.vo.Position;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    @Nested
    class 사다리를타는기능 {
        @ParameterizedTest
        @CsvSource({"0,2", "1,0", "2,1", "3,3", "4,4"})
        void test_climbDownLadder_should_도착위치반환_when_사다리를받았을때(int currentPosition, int destination) {
            // given
            Ladder ladder = new Ladder(LadderTest.generateRowList());
            Player player = new Player("abc", currentPosition);
            Position expected = new Position(destination);

            // when
            Position actual = player.climbDownLadder(ladder);

            //then
            assertThat(actual).isEqualTo(expected);
        }
    }
}
