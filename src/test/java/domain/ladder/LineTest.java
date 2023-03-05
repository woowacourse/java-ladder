package domain.ladder;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("사다리 한 층은 ")
class LineTest {

    @Nested
    @DisplayName("생성 시")
    class LineGeneration{

        @Test
        @DisplayName("올바른 모양이면 정상적으로 생성된다.")
        void validShapeLineGenerateTest() {
            assertDoesNotThrow(() -> {
                new Line(List.of(Step.RIGHT, Step.LEFT, Step.RIGHT, Step.LEFT, Step.NONE));
            });
        }

        @Test
        @DisplayName("Right - Right 모양이 포함되면 생성되지 않는다.")
        void invalidShapeLineGenerateTest() {
            assertThatThrownBy(()->{
                new Line(List.of(Step.RIGHT, Step.RIGHT, Step.RIGHT, Step.LEFT, Step.NONE));
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Left - Left 모양이 포함되면 생성되지 않는다.")
        void invalidShapeLineGenerateTest2() {
            assertThatThrownBy(()->{
                new Line(List.of(Step.LEFT, Step.LEFT, Step.RIGHT, Step.LEFT, Step.NONE));
            }).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("Right - None 모양이 포함되면 생성되지 않는다.")
        void invalidShapeLineGenerateTest3() {
            assertThatThrownBy(()->{
                new Line(List.of(Step.RIGHT, Step.NONE, Step.RIGHT, Step.LEFT, Step.NONE));
            }).isInstanceOf(IllegalArgumentException.class);
        }
    }


    @Nested
    @DisplayName("한 step 이 연결되어 있다면, 왼쪽에서 오른쪽으로 연결된 정보만 보여준다.")
    class LineInformation {
        @Test
        void rightConnectionInformationTest() {
            //given
            List<Step> steps = List.of(Step.RIGHT, Step.LEFT, Step.NONE, Step.RIGHT, Step.LEFT);

            //when
            Line line = new Line(steps);

            //then
            assertThat(line.getRightConnectionCondition()).containsExactly(true, false, false, true, false);
        }
    }

    @Nested
    @DisplayName("밟을 때")
    class RideLineCase {

        @ParameterizedTest
        @DisplayName("플레이어를 받아, 위치를 업데이트한다.")
        @CsvSource(value = {"0:1", "1:0", "2:2", "3:4", "4:3"}, delimiter = ':')
        void rideLineTest(final int startPosition, final int targetPosition) {
            //given
            List<Step> steps = List.of(Step.RIGHT, Step.LEFT, Step.NONE, Step.RIGHT, Step.LEFT);
            Player player = new Player(new Name("pobi"), new Position(startPosition));

            //when
            Line line = new Line(steps);
            Position position = line.ride(player.getPosition());

            //then
            assertThat(position.getPosition()).isEqualTo(targetPosition);
        }
    }
}
