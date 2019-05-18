package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {
    private Ladder ladder;

    @BeforeEach
    public void setUp() {
        int height = 5;

        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(Arrays.asList(true, false, true, false)));
        }

        ladder = new Ladder(lines);
    }

    @Test
    public void 사다리_잘_타는지_확인() {
        List<Integer> resultByMe = Arrays.asList(1, 0, 3, 2);
        List<Integer> resultByLadder = ladder.play();

        assertThat(resultByMe).isEqualTo(resultByLadder);
    }
}
