package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.Stick;
import domain.ladder.StickGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

    private StickGenerator filledStickGenerator() {
        return () -> Stick.FILLED;
    }
}
