package domain.ladder;

import static org.assertj.core.api.Assertions.assertThat;

import domain.player.Name;
import domain.player.Player;
import domain.player.Position;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("사다리는 ")
class LadderTest {
    @Nested
    @DisplayName("탈 때 ")
    class rideLadderCase {

        private Ladder ladder;

        @BeforeEach
        void setUp() {
            Line line1 = new Line(List.of(Step.RIGHT, Step.LEFT, Step.NONE));
            Line line2 = new Line(List.of(Step.NONE, Step.RIGHT, Step.LEFT));
            ladder = new Ladder(List.of(line1, line2));
        }


        @ParameterizedTest
        @DisplayName("플레이어를 받아 사다리를 다 내려온 뒤의 플레이어 위치를 업데이트한다.")
        @CsvSource(value = {"0:2", "1:0", "2:1"}, delimiter = ':')
        void rideLadderTest(final int startPosition, final int targetPosition) {
            //given
            Player player = new Player(new Name("pobi"), new Position(startPosition));

            //when
            Position endPosition = ladder.ride(player);

            //then
            assertThat(endPosition.getPosition()).isEqualTo(targetPosition);
        }
    }
}
