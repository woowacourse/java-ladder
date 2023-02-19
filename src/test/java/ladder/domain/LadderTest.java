package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {


    @Test
    @DisplayName("사다리가 라인 수에 맞게 생성된다.")
    void generateLadderTest() {

        class IntendedBooleanGenerator implements BooleanGenerator {

            @Override
            public Boolean generate() {
                return Boolean.TRUE;
            }
        }

        List<Line> lines = List.of(
                new Line(4, new IntendedBooleanGenerator()),
                new Line(4, new IntendedBooleanGenerator()),
                new Line(4, new IntendedBooleanGenerator()),
                new Line(4, new IntendedBooleanGenerator()),
                new Line(4, new IntendedBooleanGenerator())
        );

        Ladder ladder = new Ladder(lines);
        List<Line> copiedLines = ladder.getLines();

        assertThat(copiedLines.size()).isEqualTo(5);
    }
}
