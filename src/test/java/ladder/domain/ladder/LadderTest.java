package ladder.domain.ladder;

import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.Line;
import ladder.utils.BooleanGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderTest {

    private TrueGenerator trueGenerator = new TrueGenerator();
    private FalseGenerator falseGenerator = new FalseGenerator();

    class TrueGenerator implements BooleanGenerator {

        @Override
        public Boolean generate() {
            return Boolean.TRUE;
        }
    }

    class FalseGenerator implements BooleanGenerator {

        @Override
        public Boolean generate() {
            return Boolean.FALSE;
        }
    }

    @Test
    @DisplayName("사다리가 TRUE 라인 수에 맞게 생성된다.")
    void generateTrueLadderTest() {

        List<Line> lines = List.of(
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator)
        );

        Ladder ladder = new Ladder(lines);
        List<Line> copiedLines = ladder.getLines();

        assertThat(copiedLines.size()).isEqualTo(5);
    }

    @Test
    @DisplayName("사다리가 FALSE 라인 수에 맞게 생성된다.")
    void generateFalseLadderTest() {

        List<Line> lines = List.of(
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator)
        );

        Ladder ladder = new Ladder(lines);
        List<Line> copiedLines = ladder.getLines();

        assertThat(copiedLines.size()).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,1", "1,0", "2,3", "3,2"})
    @DisplayName("시작 위치를 받아서 사다리 최종 위치를 반환한다. (TrueGenerator)")
    void moveToEndTrueGeneratorTest(int startIndex, int resultIndex) {
        List<Line> lines = List.of(
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator),
                new Line(3, trueGenerator)
        );
        Ladder ladder = new Ladder(lines);

        Assertions.assertThat(ladder.moveToEnd(startIndex)).isEqualTo(resultIndex);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1", "2,2", "3,3"})
    @DisplayName("시작 위치를 받아서 사다리 최종 위치를 반환한다. (FalseGenerator)")
    void moveToEndFalseGeneratorTest(int startIndex, int resultIndex) {
        List<Line> lines = List.of(
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator),
                new Line(3, falseGenerator)
        );
        Ladder ladder = new Ladder(lines);

        Assertions.assertThat(ladder.moveToEnd(startIndex)).isEqualTo(resultIndex);
    }
}
