package domain.ladder;

import domain.ladder.stick.Stick;
import domain.ladder.stick.StickGenerator;
import domain.ladder.sticks.SticksGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderTest {

    @DisplayName("사다리는 높이 만큼의 라인을 갖는다.")
    @Test
    void ladderHasLines() {
        Height height = new Height(3);
        int playerSize = 9;

        Ladder ladder = new Ladder(height, playerSize, mockSticksGenerator());
        int actualHeight = ladder.getHeight();

        assertThat(actualHeight).isEqualTo(height.getHeight());
    }

    @DisplayName("사용자의 위치는 라인을 거치며 달라진다.")
    @Test
    void climbLines() {
        Height height = new Height(3);
        int playerSize = 3;

        Ladder ladder = new Ladder(height, playerSize, mockSticksGenerator());
        int position0 = ladder.climb(0);
        int position1 = ladder.climb(1);
        int position2 = ladder.climb(2);

        assertAll(
                () -> assertEquals(1, position0),
                () -> assertEquals(0, position1),
                () -> assertEquals(2, position2)
        );
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }
}
