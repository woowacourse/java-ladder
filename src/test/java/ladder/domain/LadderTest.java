package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {

    @Test
    void LadderTest() {
        AlwaysTrueCreateLine alwaysTrueCreateLine = new AlwaysTrueCreateLine();
        Ladder ladder = new Ladder(3,3,new LineGenerator(alwaysTrueCreateLine));
        List<Line> testLine = Arrays.asList(new Line(Arrays.asList(true,false),alwaysTrueCreateLine),new Line(Arrays.asList(true,false),alwaysTrueCreateLine),new Line(Arrays.asList(true,false),alwaysTrueCreateLine));

        assertThat(ladder.getLadder()).isEqualTo(testLine);
    }
}