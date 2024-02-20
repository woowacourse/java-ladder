package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    void createLadderSuccessWithHeightAndPointCount() {
        LadderHeight height = new LadderHeight("3");
        int pointCount = 3;

        Ladder ladder = Ladder.of(height, pointCount);
        List<Line> lines = ladder.getLines();
        assertAll(
                () -> Assertions.assertThat(lines.size()).isEqualTo(3),
                () -> Assertions.assertThat(lines.get(0).getPoints().size()).isEqualTo(3)
        );

    }
}
