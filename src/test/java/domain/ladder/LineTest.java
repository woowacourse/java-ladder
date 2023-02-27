package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import util.BooleanGenerator;
import util.FixBooleanGenerator;

@DisplayName("사다리 한 층은 ")
class LineTest {
    @Nested
    @DisplayName("한 step 이 연결되어 있다면, 왼쪽에서 오른쪽으로 연결된 정보만 보여준다.")
    class LineInformation {
        @Test
        void generateLineTest() {
            //given
            BooleanGenerator generator = new FixBooleanGenerator(true, true, false, true, true);

            //when
            Line line = new LineGenerator(generator).build(5);

            //then
            assertThat(line.getRightConnectionCondition()).containsExactly(true, false, false, true, false);
        }
    }

    @Nested
    @DisplayName("밟을 때")
    class RideLineCase {

        @ParameterizedTest
        @DisplayName("플레이어를 받아, 해당 플레이어의 위치를 업데이트한다.")
        @CsvSource(value = {"0:1", "1:0", "2:2", "3:4", "4:3"}, delimiter = ':')
        void rideLineTest(final int startPosition, final int targetPosition) {
            //given
            BooleanGenerator generator = new FixBooleanGenerator(true, true, false, true, true);
            Player player = new Player(new Name("pobi"), new Position(startPosition));

            //when
            Line line = new LineGenerator(generator).build(5);
            line.ride(player);

            //then
            assertThat(player.getPosition()).isEqualTo(targetPosition);
        }
    }
}
