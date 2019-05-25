package laddergame.domain;

import laddergame.domain.generator.CustomLineGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LadderTest {
    @Test
    void 사다리객체가_제대로_만들어지는지_테스트() {
        List<Line> lines = new ArrayList<>();
        lines.add(new CustomLineGenerator(Arrays.asList(true, false, true)).makeLine(3));
        lines.add(new CustomLineGenerator(Arrays.asList(false, false, false)).makeLine(3));
        lines.add(new CustomLineGenerator(Arrays.asList(false, false, true)).makeLine(3));
        Ladder ladder = new Ladder(lines, lines.size());

        assertThat(ladder).isEqualTo(ladder);
    }
}
