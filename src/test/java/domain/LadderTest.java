package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Stick;
import domain.ladder.StickGenerator;
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

        Ladder ladder = new Ladder(height, playerSize, filledStickGenerator());
        int actualHeight = ladder.getHeight();

        assertThat(actualHeight).isEqualTo(height.getHeight());
    }

    @DisplayName("사용자의 위치는 라인을 거치며 달라진다.")
    @Test
    void climbLines() {
        Height height = new Height(3);
        int playerSize = 3;

        Ladder ladder = new Ladder(height, playerSize, filledStickGenerator());
        List<Integer> positions = ladder.climbLines();

        assertAll(
                () -> assertEquals(1, positions.get(0)),
                () -> assertEquals(0, positions.get(1)),
                () -> assertEquals(2, positions.get(2))
        );
    }

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
