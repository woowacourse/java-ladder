package domain;

import domain.ladder.Line;
import domain.ladder.Stick;
import domain.ladder.StickGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    private int playerSize;
    private Line line;

    @BeforeEach
    void setUp() {
        playerSize = 3;
        line = new Line(filledStickGenerator(), playerSize); // FILLED, EMPTY
    }

    @DisplayName("라인은 인원 수 -1 만큼의 막대를 갖는다.")
    @Test
    void lineHasStick() {
        List<Stick> sticks = line.getSticks();

        assertThat(sticks).hasSize(playerSize - 1);
    }

    @DisplayName("라인에 연속된 막대는 있을 수 없다.")
    @Test
    void opposite() {
        List<Stick> sticks = line.getSticks();

        assertThat(sticks.get(playerSize - 2)).isEqualTo(Stick.NOT_FILLED);
    }

    @DisplayName("사용자의 위치는 라인을 거치며 달라진다.")
    @Nested
    class climb {

        @DisplayName("출발 위치의 오른쪽에 막대가 있으면, 오른쪽으로 이동한다.")
        @Test
        void climbWhenRightStickExist() {
            int startPosition = 0;
            int endPosition = line.climb(startPosition);

            assertThat(endPosition).isEqualTo(startPosition + 1);
        }

        @DisplayName("출발 위치의 왼쪽에 막대가 있으면, 왼쪽으로 이동한다.")
        @Test
        void climbWhenLeftStickExist() {
            int startPosition = 1;
            int endPosition = line.climb(startPosition);

            assertThat(endPosition).isEqualTo(startPosition - 1);
        }
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
